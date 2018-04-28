package com.kaishengit.tms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.commonsUtil.SnowFlake;
import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.*;
import com.kaishengit.tms.service.TicketStoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.joda.time.DateTime;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TicketStoreServiceImpl implements TicketStoreService {

    private Logger logger = LoggerFactory.getLogger(TicketStoreServiceImpl.class);

    @Value("${snowFlake.dataCenterId}")
    private Integer snowFlakeDataCenter;

    @Value("${snowFlake.machineId}")
    private Integer snowFlakeMachineId;

    @Autowired
    private TicketStroeMapper ticketStroeMapper;

    @Autowired
    private StroeAccountMapper stroeAccountMapperp;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private StroeLoginLogMapper stroeLoginLogMapper;

    @Autowired
    private TicketOrderMapper ticketOrderMapper;

    /**
     * 查找所有的代理年票客户
     *
     * @Author Reich
     * @Date: 2018/4/19 20:24
     */
    @Override
    public List<TicketStroe> findAllTicketStrop() {

        TicketStroeExample ticketStroeExample = new TicketStroeExample();
        List<TicketStroe> ticketStroeList = ticketStroeMapper.selectByExample(ticketStroeExample);
        return ticketStroeList;
    }

    /**
     * 根据代理人id删除代理人
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/19 21:16
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delTicketStroe(Integer id) {
        //查找该对象是否存在
        TicketStroe ticketStroe = ticketStroeMapper.selectByPrimaryKey(id);
        if (ticketStroe == null){
            throw new ServiceException("参数异常");
        }

        //首先删除stroeAccount中的数据
        StroeAccountExample stroeAccountExample = new StroeAccountExample();
        stroeAccountExample.createCriteria().andIdEqualTo(id);
        stroeAccountMapperp.deleteByExample(stroeAccountExample);
        //删除ticketStroe中的数据
        ticketStroeMapper.deleteByPrimaryKey(id);
        logger.info("删除代理{}",ticketStroe);

    }

    /**
     * 根据id查找TicletStroe
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/19 22:22
     */
    @Override
    public TicketStroe findTicketStroeById(Integer id) {
        return ticketStroeMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新ticketStroe
     *
     * @param ticketStroe
     * @Author Reich
     * @Date: 2018/4/19 22:47
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateTicketStroe(Integer id, TicketStroe ticketStroe) {

        ticketStroe.setUpdateTime(new Date());
        ticketStroeMapper.updateByPrimaryKeySelective(ticketStroe);

        StroeAccount stroeAccount = stroeAccountMapperp.selectByPrimaryKey(id);
        stroeAccount.setUpdateTime(new Date());
        if (!stroeAccount.getStroeAccount().equals(ticketStroe.getStroeMobile())){
            if (ticketStroe.getStroeMobile().length() < 6){
                stroeAccount.setStroePassword(DigestUtils.md5Hex(ticketStroe.getStroeMobile()));
            }
            stroeAccount.setStroePassword(DigestUtils.md5Hex(ticketStroe.getStroeMobile().substring(5)));

        }
        stroeAccount.setStroeAccount(ticketStroe.getStroeMobile());
        stroeAccountMapperp.updateByPrimaryKeySelective(stroeAccount);

        logger.info("修改{},{}",ticketStroe,stroeAccount);
    }

    /**
     * 搜索  分页
     *
     * @param pageNo
     * @param queryParam
     * @Author Reich
     * @Date: 2018/4/20 10:22
     */
    @Override
    public PageInfo<TicketStroe> findAllTicketStropByPageNo(Integer pageNo, Map<String, Object> queryParam) {

        PageHelper.startPage(pageNo,10);

        String stroeName = (String)queryParam.get("stroeName");
        String stroeMobile = (String) queryParam.get("stroeMobile");
        String stroeManager = (String) queryParam.get("stroeManager");

        TicketStroeExample ticketStroeExample = new TicketStroeExample();
        TicketStroeExample.Criteria criteria = ticketStroeExample.createCriteria();

        if(StringUtils.isNotEmpty(stroeName)) {
            criteria.andStroeNameEqualTo("%"+stroeName+"%");
        }
        if(StringUtils.isNotEmpty(stroeMobile)) {
            criteria.andStroeMobileEqualTo(stroeMobile);
        }
        if(StringUtils.isNotEmpty(stroeManager)) {
            criteria.andStroeManagerEqualTo("%"+stroeManager+"%");
        }
        ticketStroeExample.setOrderByClause("id desc");

        List<TicketStroe> ticketStroeList = ticketStroeMapper.selectByExample(ticketStroeExample);
        return new PageInfo<>(ticketStroeList);

    }

    /**
     * 通过id查找stroeAccount对象
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/20 12:21
     */
    @Override
    public StroeAccount findStroeAccountById(Integer id) {
        return stroeAccountMapperp.selectByPrimaryKey(id);
    }

    /**
     * 根据id禁用账号
     *
     * @Author Reich
     * @Date: 2018/4/20 14:28
     */
    @Override
    public void prohibitedTicketStroeById(Integer id) {

        StroeAccount stroeAccount = stroeAccountMapperp.selectByPrimaryKey(id);
        if (stroeAccount == null){
            throw new ServiceException("账户存在");
        }
        if (stroeAccount.getStroeState().equals(StroeAccount.ACCOUNT_STATE_NORMAL)){
            stroeAccount.setUpdateTime(new Date());
            stroeAccount.setStroeState(StroeAccount.ACCOUNT_STATE_DISABLE);
            stroeAccountMapperp.updateByPrimaryKeySelective(stroeAccount);
            logger.info("禁用账号{}",stroeAccount);
        }else {
            stroeAccount.setUpdateTime(new Date());
            stroeAccount.setStroeState(StroeAccount.ACCOUNT_STATE_NORMAL);
            stroeAccountMapperp.updateByPrimaryKeySelective(stroeAccount);
            logger.info("启用账号{}",stroeAccount);
        }

    }

    /**
     * 新增代理营业执照和身份信息
     *
     * @param ticketStroe
     * @Author Reich
     * @Date: 2018/4/21 16:16
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveNewTicketStorp(TicketStroe ticketStroe) {

        ticketStroe.setCreateTime(new Date());
        ticketStroeMapper.insertSelective(ticketStroe);

        //创建代理人账号
        StroeAccount stroeAccount = new StroeAccount();
        stroeAccount.setId(ticketStroe.getId());
        stroeAccount.setStroeAccount(ticketStroe.getStroeMobile());

        if (ticketStroe.getStroeMobile().length() <= 6){
            stroeAccount.setStroePassword(DigestUtils.md5Hex(ticketStroe.getStroeMobile()));
        }
        stroeAccount.setStroePassword(DigestUtils.md5Hex(ticketStroe.getStroeMobile().substring(5)));
        stroeAccount.setCreateTime(new Date());
        stroeAccount.setStroeState(StroeAccount.ACCOUNT_STATE_NORMAL);
        stroeAccountMapperp.insertSelective(stroeAccount);

    }

    /**
     * 通过手机号查找代理人
     *
     * @param userMobile
     * @Author Reich
     * @Date: 2018/4/25 20:49
     */
    @Override
    public StroeAccount findAccountByMobile(String userMobile) {
        StroeAccountExample stroeAccountExample = new StroeAccountExample();
        stroeAccountExample.createCriteria().andStroeAccountEqualTo(userMobile);
        List<StroeAccount> stroeAccountList = stroeAccountMapperp.selectByExample(stroeAccountExample);
        return stroeAccountList.get(0);

    }

    /**
     * 保存代理登录星系
     *
     * @param stroeLoginLog
     * @Author Reich
     * @Date: 2018/4/25 21:08
     */
    @Override
    public void saveAccountLoginLog(StroeLoginLog stroeLoginLog) {
        stroeLoginLogMapper.insert(stroeLoginLog);
    }

    /**
     * 通过id查找当前登录代理的销售信息
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/27 13:07
     */
    @Override
    public Map<String, Long> countTicketByStateStroeAccountId(Integer id) {
        return ticketStroeMapper.countByStateAndStoreAccountId(id);
    }

    /**
     * 保存客户购票信息
     *
     * @param customer
     * @Author Reich
     * @Date: 2018/4/27 21:29
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveTicketCustomer(Customer customer, TicketStroe ticketStroe, String ticketNum, BigDecimal ticketPrice) throws ServiceException {

        //首先查找该年票是否存在
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketNumEqualTo(Integer.valueOf(ticketNum));

        List<Ticket> ticketList = ticketMapper.selectByExample(ticketExample);
        if (ticketList != null && !ticketList.isEmpty()){
            Ticket ticket = ticketList.get(0);
            //判断该年票状态
            if (Ticket.TICKET_STATE_OUT_STORE.equals(ticket.getTicketState())){
                //判断该年票是否属于当前登录代理
                if (ticket.getStroeAccountId().equals(ticketStroe.getId())){
                    //判断该用户是否办理过年票业务
                   CustomerExample customerExample = new CustomerExample();
                   customerExample.createCriteria().andCustomerIdCardEqualTo(customer.getCustomerIdCard());
                    List<Customer> customerList = customerMapper.selectByExample(customerExample);
                    if (customerList != null && !customerList.isEmpty()){

                        Customer oldcustomer = customerList.get(0);
                        //判断当前客户是否绑定过年票业务
                        Ticket ticketCustomer = ticketMapper.selectByPrimaryKey(oldcustomer.getId());
                        if (ticketCustomer != null ){
                            if (Ticket.TICKET_STATE_SALE.equals(ticketCustomer.getTicketState())){
                                throw new ServiceException("该客户订购过你年票业务，不可再次订购");
                            }
                        }else {
                            //用户存在，但未绑定年票业务
                            customer = oldcustomer;
                        }
                    }else {
                        //保存客户
                        customer.setCustomerTicketId(ticket.getId().toString());
                        customer.setCreateTime(new Date());
                        customerMapper.insertSelective(customer);
                    }
                    //将年票状态改为已销售
                    ticket.setTicketState(Ticket.TICKET_STATE_SALE);

                    //设置年票有效期~~~~数据库字段类型设置错误
                    DateFormat dateFormat = new SimpleDateFormat();
                    ticket.setTicketValidityStart(new Date());
                    //设置过期时间
                    DateFormat endDateFormat = new SimpleDateFormat();
                    DateTime endTime = DateTime.now().plusYears(1);
                    ticket.setTicketValidityEnd(endTime.toDate());

                    //绑定销售用户
                    ticket.setCustomerId(customer.getId());
                    //修改年票对象
                    ticketMapper.updateByPrimaryKeySelective(ticket);

                    //创建销售订单
                    TicketOrder ticketOrder = new TicketOrder();
                    ticketOrder.setCreateTime(new Date());
                    ticketOrder.setCustomerId(customer.getId());
                    ticketOrder.setStroeAccountId(ticketStroe.getId());
                    ticketOrder.setTicketId(ticket.getId());
                    ticketOrder.setTicketOrdePrice(ticketPrice.longValue());

                    //设置流水号
                    SnowFlake snowFlake = new SnowFlake(snowFlakeDataCenter, snowFlakeMachineId);
                    ticketOrder.setTicketOrderNum(String.valueOf(snowFlake.nextId()));
                    ticketOrder.setTicketOrderType(TicketOrder.ORDER_TYPE_NEW);

                    ticketOrderMapper.insertSelective(ticketOrder);
                }else {
                    throw new ServiceException("该年票不属于" + stroeAccountMapperp.selectByPrimaryKey(ticketStroe.getId()));
                }

            }else {
                throw new ServiceException("该年票状态异常");
            }

        }else {
            throw new ServiceException("该年票不存在，请核查票号");
        }
        logger.info("添加客户{}",customer);

    }

}
