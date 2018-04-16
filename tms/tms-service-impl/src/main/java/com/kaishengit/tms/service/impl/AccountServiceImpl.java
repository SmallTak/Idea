package com.kaishengit.tms.service.impl;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.AccountExample;
import com.kaishengit.tms.entity.AccountLoginLog;
import com.kaishengit.tms.entity.AccountRolesKey;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.AccountLoginLogMapper;
import com.kaishengit.tms.mapper.AccountMapper;
import com.kaishengit.tms.mapper.AccountRolesMapper;
import com.kaishengit.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


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

    @Autowired
    private AccountRolesMapper accountRolesMapper;

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

    /**
     * 新建账户
     *
     * @param account  账号对象
     * @param rolesIds  账号拥有的角色id
     * @Author Reich
     * @Date: 2018/4/16 19:34
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveAccount(Account account, Integer[] rolesIds) {
        //设置账号创建的时间
        account.setCreateTime(new Date());
        String password;
        if (account.getAccountMobile().length() <= 6){
            password = account.getAccountMobile();
        }else {
            password = account.getAccountMobile().substring(6);
        }

        //对用户密码进行md5加密
        password = DigestUtils.md5Hex(password);
        account.setAccountPassword(password);
        //设置账号默认状态
        account.setAccountState(Account.STATE_NORMAL);
        accountMapper.insertSelective(account);

        //添加用户和角色关系
        for (Integer rolesId : rolesIds){
            AccountRolesKey accountRolesKey = new AccountRolesKey();
            accountRolesKey.setAccountId(account.getId());
            accountRolesKey.setRolesId(rolesId);
            accountRolesMapper.insert(accountRolesKey);
        }
    }

    /**
     * 搜索框
     * 根据UI传来的查询参数查询所有账号并加载对应的角色列表
     * @param objectMap
     * @Author Reich
     * @Date: 2018/4/16 21:09
     */
    @Override
    public List<Account> findAllAccountWithRolesByQueryParam(Map<String, Object> objectMap) {

        return accountMapper.findAllAccountWithRolesByQueryParam(objectMap);
    }


}
