package com.kaishengit.tms.service.impl;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.AccountExample;
import com.kaishengit.tms.entity.AccountLoginLog;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.AccountLoginLogMapper;
import com.kaishengit.tms.mapper.AccountMapper;
import com.kaishengit.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 系统账号的业务类
 * @Author Reich
 * @Date: 2018/4/12 19:27
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountLoginLogMapper accountLoginLogMapper;


    public void test(){

    }


    /**
     * @param accountMobile 登陆员工的账号
     * @param password      登陆员工密码
     * @param accountIp     登录员工的ip
     * @return 若登录成则返回account对象  失败返回null
     * @Author Reich
     * @Date: 2018/4/12 20:59
     */
    @Override
    public Account login(String accountMobile, String password, String accountIp) {
        //根据手机号查找对应的用户
        AccountExample accountExample = new AccountExample();
        //设置查询条件
        accountExample.createCriteria().andAccountMobileEqualTo(accountMobile);

        List<Account> accountList = accountMapper.selectByExample(accountExample);

        Account account = null;
        if (accountList != null && !accountList.isEmpty()){

            account = accountList.get(0);
            //判断用户密码是否正确
            if (account.getAccountPassword().equals(DigestUtils.md5Hex(password))){
                //判断用户状态
                if (Account.STATE_NORMAL.equals(account.getAccountState())) {
                    //添加用户登录日志
                    AccountLoginLog accountLoginLog = new AccountLoginLog();
                    accountLoginLog.setAccountId(account.getId());
                    accountLoginLog.setLoginIp(accountIp);
                    accountLoginLog.setLoginTime(new Date());
                    accountLoginLogMapper.insert(accountLoginLog);

                    logger.info("{}：登陆系统",account);
                    return account;

                }else if (Account.STATE_LOCKED.equals(account.getAccountState())){
                    throw new ServiceException("用户被锁定");
                }else {
                    throw new ServiceException("用户被禁用");
                }
            } else {
                throw new ServiceException("账号或者密码不匹配");
            }

        }else {
            throw new ServiceException("账号或者密码错误");
        }
    }
}
