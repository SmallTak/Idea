package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Account;

/**
 * 系统账号的业务类
 * @Author Reich
 * @Date: 2018/4/12 19:27
 */
public interface AccountService {

    /**
     * @param accountMobile 登陆员工的账号
     * @param password  登陆员工密码
     * @param accountIp 登录员工的ip
     * @Author Reich
     * @Date: 2018/4/12 20:59
     */
    Account login(String accountMobile, String password, String accountIp);
}
