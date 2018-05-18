package com.kaishengit.service;

import com.kaishengit.entity.Account;

public interface AccountService {

    /**查着账户
     *
     * @Author Reich
     * @Date: 2018/5/18 14:51
     */
    Account login(String userName, String password);

    /**通过id查找用户
     *
     * @Author Reich
     * @Date: 2018/5/18 20:31
     */
    Account finfAccountById(Integer idFromToken);
}
