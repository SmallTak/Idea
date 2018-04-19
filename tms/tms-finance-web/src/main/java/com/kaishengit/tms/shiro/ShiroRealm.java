package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.AccountLoginLog;
import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolesPermissionService;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private RolesPermissionService rolesPermissionService;

    /** 判断用户角色及权限
     *
     * @Author Reich
     * @Date: 2018/4/17 16:32
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Account account = (Account) principalCollection.getPrimaryPrincipal();
        List<Roles> rolesList = rolesPermissionService.findRolesByAccountId(account.getId());

        //获取当前对象拥有角色的权限
        List<Permission> permissionList = new ArrayList<>();
        for (Roles roles : rolesList){
            //根据角色id查出权限集合
            List<Permission> permissions = rolesPermissionService.findPermissionByRolesId(roles.getId());
            permissionList.addAll(permissions);
        }

        //因为simpleAuthorizationInfo对象中的setRoles()中需要传入角色的Set集合,所以需要迭代角色集合add到Set集合中
        Set<String> rolesNameSet = new HashSet<>();
        for (Roles roles : rolesList){
            rolesNameSet.add(roles.getRolesCode());
        }
        //因为simpleAuthorizationInfo对象中的ssetStringPermissions()中需要传入权限的Set集合,所以需要迭代角色集合add到Set集合中
        Set<String> permissionNameSet = new HashSet<>();
        for (Permission permission : permissionList){
            permissionNameSet.add(permission.getPermissionCode());
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //set当前用户拥有的角色
        simpleAuthorizationInfo.setRoles(rolesNameSet);
        //set当前用于拥有的权限
        simpleAuthorizationInfo.setStringPermissions(permissionNameSet);

        return simpleAuthorizationInfo;
    }

    /** 判断登录
     *
     * @throws AuthenticationException
     * @Author Reich
     * @Date: 2018/4/17 16:32
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userMobile = usernamePasswordToken.getUsername();
        if (userMobile != null){
           Account account = accountService.findAccountByMobile(userMobile);
            if (account == null){
                throw new UnknownAccountException("找不到该账户" + userMobile);
            }else{
                if (Account.STATE_NORMAL.equals(account.getAccountState())){
                    logger.info("{} 登录成功: {}",account,usernamePasswordToken.getHost());

                    //保存登录日志
                    AccountLoginLog accountLoginLog = new AccountLoginLog();
                    accountLoginLog.setLoginTime(new Date());
                    accountLoginLog.setLoginIp(usernamePasswordToken.getHost());
                    accountLoginLog.setAccountId(account.getId());
                    accountService.saveAccountLoginLog(accountLoginLog);

                    return new SimpleAuthenticationInfo(account,account.getAccountPassword(),getName());
                }else {
                    throw new LockedAccountException("账号被禁用或锁定:" + account.getAccountState());
                }
            }
        }
        return null;
    }
}
