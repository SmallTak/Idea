package com.kaishengit.service.impl;

import com.kaishengit.entity.TAccount;
import com.kaishengit.entity.TAccountExample;
import com.kaishengit.mapper.TAccountMapper;
import com.kaishengit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private TAccountMapper tAccountMapper;

    @Override
    public List<TAccount> findByMobile(String mobile, String password) {
       TAccountExample tAccountExample = new TAccountExample();
       tAccountExample.createCriteria().andMobileEqualTo(mobile);
        return tAccountMapper.selectByExample(tAccountExample);

    }

}
