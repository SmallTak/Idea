package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Account;

import java.util.List;
import java.util.Map;

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

    /**
     * 新建账户
     * @Author Reich
     * @Date: 2018/4/16 19:34
     */
    void saveAccount(Account account, Integer[] rolesIds);

    /**搜索框
     *根据UI传来的查询参数查询所有账号并加载对应的角色列表
     * @Author Reich
     * @Date: 2018/4/16 21:09
     */
    List<Account> findAllAccountWithRolesByQueryParam(Map<String, Object> objectMap);

    /**
     * 根据id查找账户
     * @Author Reich
     * @Date: 2018/4/16 22:21
     */
    Account findByAccountId(Integer id);

    /**更新账户
     *
     * @Author Reich
     * @Date: 2018/4/16 22:55
     */
    void updateAccount(Account account, Integer[] rolesIds);
}
