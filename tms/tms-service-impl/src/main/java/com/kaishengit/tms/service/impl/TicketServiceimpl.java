package com.kaishengit.tms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.TicketInRecordMapper;
import com.kaishengit.tms.mapper.TicketMapper;
import com.kaishengit.tms.mapper.TicketOutRecordMapper;
import com.kaishengit.tms.mapper.TicketStroeMapper;
import com.kaishengit.tms.service.TicketService;
import com.kaishengit.tms.util.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TicketServiceimpl implements TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketServiceimpl.class);

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private TicketInRecordMapper ticketInRecordMapper;

    @Autowired
    private TicketStroeMapper ticketStroeMapper;

    @Autowired
    private TicketOutRecordMapper ticketOutRecordMapper;


    /**
     * 年票入库
     *
     * @Author Reich
     * @Date: 2018/4/20 19:15
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveTicketInWarehouse(TicketInRecord ticketInRecord, Account account) throws ServiceException {

        ticketInRecord.setCreateTime(new Date());

        //设置起始票号 和 结束票号
        BigInteger startNum = new BigInteger(ticketInRecord.getBeginTicketNum());
        BigInteger endNum = new BigInteger(ticketInRecord.getEndTicketNum());

        if (startNum.compareTo(endNum) >= 0){
            throw new ServiceException("起始票号必须小于截止票号");
        }

        //判断当前用户入库的年票区间在不在已入库的区间范围内
        List<TicketInRecord> ticketInRecordList = ticketInRecordMapper.selectByExample(new TicketInRecordExample());
        for (TicketInRecord ticket : ticketInRecordList){
            //数据库中年票的起始和截至票号
            BigInteger oldStart = new BigInteger(ticket.getBeginTicketNum());
            BigInteger oldEnd = new BigInteger(ticket.getEndTicketNum());
            boolean flag = (oldStart.compareTo(startNum) <= 0 && oldEnd.compareTo(startNum) >= 0) || (oldStart.compareTo(endNum) <= 0 && oldEnd.compareTo(endNum) >= 0);
            if (flag){
                throw new ServiceException("年票号区间重复，添加失败");
            }
        }

        //设置总入库数量
        BigInteger totalNum = endNum.subtract(startNum).add(new BigInteger(String.valueOf("1")));
        ticketInRecord.setTotalNum(totalNum.intValue());

        //获取当前登录对象
        ticketInRecord.setAccountId(account.getId());
        ticketInRecord.setAccountName(account.getAccountName());

        //设置入库的票号范围
        ticketInRecord.setContent(ticketInRecord.getBeginTicketNum()+"~"+ticketInRecord.getEndTicketNum());

        ticketInRecordMapper.insertSelective(ticketInRecord);

        //设置年票添加记录
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < totalNum.intValue(); i++){
            Ticket ticket = new Ticket();
            ticket.setCreateTime(new Date());
            ticket.setTicketInTime(new Date());
            ticket.setTicketNum(startNum.add(new BigInteger(String.valueOf(i))).intValue());
            ticket.setTicketState(Ticket.TICKET_STATE_IN_STORE);
            tickets.add(ticket);
        }
        //批量保存年票记录
        ticketMapper.batchInsert(tickets);
    }

    /**
     * 查找所有入库记录
     *
     * @Author Reich
     * @Date: 2018/4/20 22:32
     */
    @Override
    public List<TicketInRecord> findTicketAndTicketInRecord() {
        TicketInRecordExample ticketInRecordExample = new TicketInRecordExample();
        return ticketInRecordMapper.selectByExample(ticketInRecordExample);
    }

    /**
     * 通过id删除入库记录
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/20 23:15
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delTicketInRecordById(Integer id) throws ServiceException  {

        TicketInRecord ticketInRecord = ticketInRecordMapper.selectByPrimaryKey(id);
        if (ticketInRecord != null) {

            //查找出该区间的年票list集合
            List<Ticket> byBeginNumAndEndNum = ticketMapper.findByBeginNumAndEndNum(ticketInRecord.getBeginTicketNum(), ticketInRecord.getEndTicketNum());
            //判断该区间内有没有已经已下发的，若有则抛出异常
            for (Ticket ticket : byBeginNumAndEndNum){
                if (!ticket.getTicketState().equals(Ticket.TICKET_STATE_IN_STORE)){
                    throw new ServiceException("该年票区间内有非已入库的年票，请核对后操作删除");
                }
            }

            List<Long> idList = Lists.newArrayList(Collections2.transform(byBeginNumAndEndNum, new Function<Ticket, Long>() {
                @Nullable
                @Override
                public Long apply(@Nullable Ticket input) {
                    return input.getId().longValue();
                }
            }));

            //根据ticketInRecord中的起始年票号查找ticket
            ticketMapper.batchDeleteById(idList);
            ticketInRecordMapper.deleteByPrimaryKey(id);

            logger.info("删除入库记录{}", ticketInRecord);
        }
    }

    /**
     * 年票入库信息回显
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/21 10:32
     */
    @Override
    public TicketInRecord findTicketInRecord(Integer id) {

        return ticketInRecordMapper.selectByPrimaryKey(id);

    }

    /**
     * 修改年票入库信息
     *
     * @param id
     * @param ticketInRecord
     * @Author Reich
     * @Date: 2018/4/21 10:49
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateTicketInRecord(Integer id, TicketInRecord ticketInRecord) {
        //设置更新时间
        ticketInRecord.setUpdateTime(new Date());
        //更新入库内容
        ticketInRecord.setContent(ticketInRecord.getBeginTicketNum() + "~" + ticketInRecord.getEndTicketNum());
        //更新总数量
        BigInteger start = new BigInteger(ticketInRecord.getBeginTicketNum());
        BigInteger end = new BigInteger(ticketInRecord.getEndTicketNum());
        ticketInRecord.setTotalNum(end.subtract(start).add(new BigInteger("1")).intValue());
        //更新ticketInrecord（入库记录）表
        ticketInRecordMapper.updateByPrimaryKeySelective(ticketInRecord);

        //把需更新的内容add到list集合
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < Integer.valueOf(ticketInRecord.getEndTicketNum()); i++){
            Ticket ticket = new Ticket();
            ticket.setTicketNum(start.add(new BigInteger(String.valueOf(i))).intValue());
            ticket.setUpdateTime(new Date());

            ticketList.add(ticket);
        }
        ticketMapper.batchUpdate(ticketList);

    }

    /**
     * 查询所有的年票代理点
     *
     * @Author Reich
     * @Date: 2018/4/23 11:05
     */
    @Override
    public List<TicketStroe> findAllTikcetStroe() {
        TicketStroeExample ticketStroeExample = new TicketStroeExample();
        return ticketStroeMapper.selectByExample(ticketStroeExample);
    }

    /**
     * 新增年票下发
     *
     * @param ticketOutRecord
     * @Author Reich
     * @Date: 2018/4/23 11:21
     */
    @Override
    public void saveTicketOut(TicketOutRecord ticketOutRecord, Account account) throws ServiceException {

        //根据下发年票的起始票号和截至票号来判断该区间内有没有已下发的
        List<Ticket> ticketList = ticketMapper.findByBeginNumAndEndNum(ticketOutRecord.getBeginTicketNum(),ticketOutRecord.getEndTicketNum());
        for (Ticket ticket : ticketList){
            if (!Ticket.TICKET_STATE_IN_STORE.equals(ticket.getTicketState())){
                throw new ServiceException("该区间内有已下发的年票，请重新选择");
            }
        }
        //获取当前下发年票的起始票号
        BigInteger startNum = new BigInteger(ticketOutRecord.getBeginTicketNum());
        //获取当前下发年票的截止票号
        BigInteger endNum = new BigInteger(ticketOutRecord.getEndTicketNum());
        //查找出所有已入库的年票
        List<TicketInRecord> ticketInRecordList = ticketInRecordMapper.selectByExample(new TicketInRecordExample());
        for (TicketInRecord ticketInRecord : ticketInRecordList ){

            BigInteger oldStart = new BigInteger(ticketInRecord.getBeginTicketNum());
            BigInteger oldEnd = new BigInteger(ticketInRecord.getEndTicketNum());
            boolean flag = (oldStart.compareTo(startNum) <= 0 && oldEnd.compareTo(startNum) >= 0) && (oldStart.compareTo(endNum) < 0 && oldEnd.compareTo(endNum) >= 0);
            if (!flag){
                throw new ServiceException("下发年票必须在库存年票区间内，请重新选择");
            }
        }
        //获取当前年票下发的代理对象
        TicketStroe ticketStroe = ticketStroeMapper.selectByPrimaryKey(ticketOutRecord.getTicketStoreAccountid());
        ticketOutRecord.setTicketStoreAccountname(ticketStroe.getStroeName());

        //获得总数量
        int totalNum = ticketList.size();
        //获得总价格
        BigDecimal totalPrice = ticketOutRecord.getTicketPrice().multiply(new BigDecimal(totalNum));
        //设置创建时间
        ticketOutRecord.setCreateTime(new Date());
        ticketOutRecord.setContent(ticketOutRecord.getBeginTicketNum()+ "~" +ticketOutRecord.getEndTicketNum());
        ticketOutRecord.setOutAccountid(account.getId());
        ticketOutRecord.setTicketOutAccountName(account.getAccountName());
        ticketOutRecord.setTicketNum(totalNum);
        ticketOutRecord.setTicketState(TicketOutRecord.STATE_NO_PAY);
        ticketOutRecord.setTicketTotalPrice(totalPrice);

        ticketOutRecordMapper.insertSelective(ticketOutRecord);
        logger.info("新增年票下发记录：{}",ticketOutRecord);


    }

    /**
     * 查出所有的出库记录
     *
     * @Author Reich
     * @Date: 2018/4/23 14:28
     */
    @Override
    public PageInfo<TicketOutRecord> findAllTicketOutRecord(Integer pageNo) {

        PageHelper.startPage(pageNo,10);

        TicketOutRecordExample ticketOutRecordExample = new TicketOutRecordExample();
        ticketOutRecordExample.setOrderByClause("id desc");

        List<TicketOutRecord> ticketOutRecords = ticketOutRecordMapper.selectByExample(ticketOutRecordExample);
        return new  PageInfo<>(ticketOutRecords) ;
    }

    /**
     * 通过id删除年票下发记录
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/23 16:56
     */
    @Override
    public void delTicketOutRecord(Integer id) throws ServiceException {

        TicketOutRecord ticketOutRecord = ticketOutRecordMapper.selectByPrimaryKey(id);
        if (ticketOutRecord == null){
            throw new ServiceException("参数异常");
        }

//        List<Ticket> byBeginNumAndEndNum = ticketMapper.findByBeginNumAndEndNum(ticketOutRecord.getBeginTicketNum(), ticketOutRecord.getEndTicketNum());
//
//        for (Ticket ticket : byBeginNumAndEndNum){
//            ticket.setTicketState(Ticket.TICKET_STATE_IN_STORE);
//        }

        ticketOutRecordMapper.deleteByPrimaryKey(id);

    }

    /**
     * 数据统计
     *
     * @Author Reich
     * @Date: 2018/4/23 22:07
     */
    @Override
    public Map<String, Long> countTicketByState() {
        return ticketMapper.countByState();
    }

    /**
     * 查找所有年票的下发记录
     *
     * @param pageNo
     * @param queryParam
     * @Author Reich
     * @Date: 2018/4/24 12:44
     */
    @Override
    public PageInfo<TicketOutRecord> findAllTicketOutAndPage(Integer pageNo, Map<String, Object> queryParam) {

        PageHelper.startPage(pageNo, 10);

        //根据条件查询判断state是否为空
        TicketOutRecordExample ticketOutRecordExample = new TicketOutRecordExample();
        TicketOutRecordExample.Criteria criteria = ticketOutRecordExample.createCriteria();

        String state = (String) queryParam.get("state");
        if (StringUtils.isNoneEmpty(state)) {
            criteria.andTicketStateEqualTo(state);
        }
        ticketOutRecordExample.setOrderByClause("id desc");
        List<TicketOutRecord> ticketOutRecords = ticketOutRecordMapper.selectByExample(ticketOutRecordExample);

        return new PageInfo<>(ticketOutRecords);
    }

    /**
     * 通过id查找缴费年票订单的金额
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/24 14:17
     */
    @Override
    public TicketOutRecord findTicketOutRecordPay(Integer id) {
        return ticketOutRecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 提交缴费记录
     *
     * @param id
     * @param paymentMethod
     * @Author Reich
     * @Date: 2018/4/24 14:24
     */
    @Override
    public void savePayRecord(Integer id, String paymentMethod, Account account) throws ServiceException {

        //通过id查找到需要缴费的订单
        TicketOutRecord ticketOutRecord = ticketOutRecordMapper.selectByPrimaryKey(id);
        if (ticketOutRecord == null){
            throw  new ServiceException("参数异常");
        }
        ticketOutRecord.setUpdateTime(new Date());
        ticketOutRecord.setFinanceAccountName(account.getAccountName());
        ticketOutRecord.setPaymentMethod(paymentMethod);
        ticketOutRecord.setFinanceAccountid(account.getId());
        ticketOutRecord.setTicketState(TicketOutRecord.STATE_PAY);

        ticketOutRecordMapper.updateByPrimaryKeySelective(ticketOutRecord);
        logger.info("缴费{}",ticketOutRecord);
    }

    /**
     * 通过年票id查找年票
     *
     * @param ticketNum
     * @Author Reich
     * @Date: 2018/5/1 20:47
     */
    @Override
    public Ticket findTicketByTicketNum(String ticketNum) {
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketNumEqualTo(Integer.valueOf(ticketNum));
        return ticketMapper.selectByExample(ticketExample).get(0);
    }

}
