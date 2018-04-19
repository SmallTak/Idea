package com.kaishengit.tms.service.impl;

import com.kaishengit.tms.entity.StroeAccount;
import com.kaishengit.tms.entity.StroeAccountExample;
import com.kaishengit.tms.entity.TicketStroe;
import com.kaishengit.tms.entity.TicketStroeExample;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.StroeAccountMapper;
import com.kaishengit.tms.mapper.TicketStroeMapper;
import com.kaishengit.tms.service.TicketStoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TicketStoreServiceImpl implements TicketStoreService {

    private Logger logger = LoggerFactory.getLogger(TicketStoreServiceImpl.class);

    @Autowired
    private TicketStroeMapper ticketStroeMapper;

    @Autowired
    private StroeAccountMapper stroeAccountMapperp;


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
        stroeAccountExample.createCriteria().andTicketStroeIdEqualTo(id);
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

        StroeAccountExample stroeAccountExample = new StroeAccountExample();
        stroeAccountExample.createCriteria().andTicketStroeIdEqualTo(id);

        List<StroeAccount> stroeAccounts = stroeAccountMapperp.selectByExample(stroeAccountExample);
        StroeAccount stroeAccount = stroeAccounts.get(0);
        stroeAccount.setUpdateTime(new Date());
        if (ticketStroe.getStroeMobile().length() < 6){
            stroeAccount.setStroePassword(DigestUtils.md5Hex(ticketStroe.getStroeMobile()));
        }
        stroeAccount.setStroePassword(DigestUtils.md5Hex(ticketStroe.getStroeMobile().substring(5)));
        stroeAccountMapperp.updateByPrimaryKeySelective(stroeAccount);
        logger.info("修改{}",ticketStroe);
        logger.info("修改{}",stroeAccount);
    }


}
