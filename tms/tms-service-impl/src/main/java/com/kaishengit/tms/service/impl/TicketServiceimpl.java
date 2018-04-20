package com.kaishengit.tms.service.impl;

import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.TicketInRecordMapper;
import com.kaishengit.tms.mapper.TicketMapper;
import com.kaishengit.tms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketServiceimpl implements TicketService {

//    @Autowired
//    private ShiroUtil shiroUtil;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private TicketInRecordMapper ticketInRecordMapper;

    /**
     * 年票入库
     *
     * @Author Reich
     * @Date: 2018/4/20 19:15
     */
    @Override
    public void saveTicketInWarehouse(TicketInRecord ticketInRecord, Account account) {

        ticketInRecord.setCreateTime(new Date());

        //设置起始票号 和 结束票号
        BigInteger startNum = new BigInteger(ticketInRecord.getBeginTicketNum());
        BigInteger endNum = new BigInteger(ticketInRecord.getEndTicketNum());

        //设置总入库数量
        BigInteger totalNum = endNum.subtract(startNum).add(new BigInteger(String.valueOf("1")));
        ticketInRecord.setTotalNum(totalNum.intValue());

        //获取当前登录对象
//        Account account = shiroUtil.getCurrAccount();
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
            ticket.setTicketValidityStart(ticketInRecord.getBeginTicketNum());
            ticket.setTicketValidityEnd(ticketInRecord.getEndTicketNum());
            ticket.setTicketNum(startNum.add(new BigInteger(String.valueOf(i))).toString());
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
    public void delTicketInRecordById(Integer id) {

        TicketInRecord ticketInRecord = ticketInRecordMapper.selectByPrimaryKey(id);
        if (ticketInRecord == null){
            throw new ServiceException("参数异常");
        }

        //根据ticketInRecord中的起始年票号查找ticket
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketNumBetween(ticketInRecord.getBeginTicketNum(),ticketInRecord.getEndTicketNum());
        ticketMapper.deleteByExample(ticketExample);

    }

}
