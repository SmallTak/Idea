package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.TicketStoreService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private TicketStoreService ticketStoreService;

    /** 判断用户角色及权限
     *
     * @Author Reich
     * @Date: 2018/4/17 16:32
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
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
            StroeAccount stroeAccount = ticketStoreService.findAccountByMobile(userMobile);
            if (stroeAccount == null){
                throw new UnknownAccountException("找不到该账户" + userMobile);
            }else{
                if (StroeAccount.ACCOUNT_STATE_NORMAL.equals(stroeAccount.getStroeState())){
                    logger.info("{} 登录成功: {}",stroeAccount,usernamePasswordToken.getHost());

                    TicketStroe ticketStroe = ticketStoreService.findTicketStroeById(stroeAccount.getId());

                    //保存登录日志
                    StroeLoginLog stroeLoginLog = new StroeLoginLog();
                    stroeLoginLog.setId(stroeAccount.getId());
                    stroeLoginLog.setLoginIp(usernamePasswordToken.getHost());
                    ticketStoreService.saveAccountLoginLog(stroeLoginLog);

                    return new SimpleAuthenticationInfo(ticketStroe,stroeAccount.getStroePassword(),getName());
                }else {
                    throw new LockedAccountException("账号被禁用或锁定:" + stroeAccount.getStroeState());
                }
            }
        }
        return null;
    }
}
