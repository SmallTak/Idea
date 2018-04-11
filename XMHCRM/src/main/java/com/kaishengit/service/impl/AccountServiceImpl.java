package com.kaishengit.service.impl;

import com.kaishengit.entity.Account;
import com.kaishengit.entity.Customer;
import com.kaishengit.mapper.AccountMapper;
import com.kaishengit.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByMobile(String mobile, String password) {
        return accountMapper.findByMobile(mobile);

    }

    @Override
    public void updateAccount(Customer customer) {
        accountMapper.updateAccount();
    }
}
