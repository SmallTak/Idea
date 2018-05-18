package com.kaishengit.service.serviceImpl;

import com.kaishengit.entity.Account;
import com.kaishengit.entity.AccountExample;
import com.kaishengit.mapper.AccountMapper;
import com.kaishengit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 查着账户
     *
     * @Author Reich
     * @Date: 2018/5/18 14:51
     */
    @Override
    public Account login(String userName, String password) {

        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUserNameEqualTo(userName);

        List<Account> accounts = accountMapper.selectByExample(accountExample);
        Account account = accounts !=null && !accounts.isEmpty() ? accounts.get(0) : null;

        if(account == null) {
            throw new RuntimeException("账号或密码错误");
        } else {
            if(account.getPassword().equals(password)) {
                return account;
            } else {
                throw new RuntimeException("账号或密码错误");
            }
        }
    }

    /**
     * 通过id查找用户
     *
     * @param idFromToken
     * @Author Reich
     * @Date: 2018/5/18 20:31
     */
    @Override
    public Account finfAccountById(Integer idFromToken) {
        return accountMapper.selectByPrimaryKey(idFromToken);
    }
}
