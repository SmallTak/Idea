package com.kaishengit.tms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.StroeAccount;
import com.kaishengit.tms.entity.StroeAccountExample;
import com.kaishengit.tms.entity.TicketStroe;
import com.kaishengit.tms.entity.TicketStroeExample;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.StroeAccountMapper;
import com.kaishengit.tms.mapper.TicketStroeMapper;
import com.kaishengit.tms.service.TicketStoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
        stroeAccount.setUpdateTime(new Date());
        stroeAccount.setStroeState(StroeAccount.ACCOUNT_STATE_DISABLE);
        stroeAccountMapperp.updateByPrimaryKeySelective(stroeAccount);
        logger.info("禁用账号{}",stroeAccount);

    }

}
