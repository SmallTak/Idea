package com.kaishengit.service;

import com.kaishengit.entity.TAccount;

import java.util.List;

public interface AccountService {


    List<TAccount> findByMobile(String mobile, String password);


}
