package com.kaishengit.service;

import com.kaishengit.entity.Account;
import com.kaishengit.entity.Customer;
import com.kaishengit.mapper.AccountMapper;

public interface AccountService {


    Account findByMobile(String mobile, String password);

    void updateAccount(Customer customer);
}
