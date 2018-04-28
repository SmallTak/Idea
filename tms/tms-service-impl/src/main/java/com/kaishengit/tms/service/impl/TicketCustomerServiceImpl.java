package com.kaishengit.tms.service.impl;

import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.CustomerMapper;
import com.kaishengit.tms.mapper.TicketMapper;
import com.kaishengit.tms.service.TicketCustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketCustomerServiceImpl implements TicketCustomerService {

    public static final Logger logger = LoggerFactory.getLogger(TicketCustomerService.class);

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 保存客户购票信息
     *
     * @param customer
     * @Author Reich
     * @Date: 2018/4/27 21:29
     */
    @Override
    public void saveTicketCustomer(Customer customer, StroeAccount stroeAccount) throws ServiceException {

        customer.setCreateTime(new Date());
        //设置给客户办理的年票id
        /*TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketStateEqualTo(Ticket.TICKET_STATE_IN_STORE).andStroeAccountIdEqualTo(stroeAccount.getId());*/
       /* List<Ticket> ticketList = ticketMapper.selectByExample(ticketExample);*/
        List<Ticket> ticketList = ticketMapper.selectByStroeIdAndTicketStatu(stroeAccount.getId());
        Ticket ticket = ticketList.get(0);
        if (ticket == null){
            throw new ServiceException("年票库存不足");
        }
        ticket.setTicketState(Ticket.TICKET_STATE_SALE);
        ticketMapper.updateByPrimaryKey(ticket);
        customer.setCustomerTicketId(String.valueOf(ticket.getId()));

        customerMapper.insertSelective(customer);

        logger.info("添加客户{}",ticket.getId());


    }
}
