package com.kaishengit.mapper;

import com.kaishengit.entity.Account;

public interface AccountMapper {

    Account findByMobile(String mobile);

}
