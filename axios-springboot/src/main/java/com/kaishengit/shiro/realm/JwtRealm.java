package com.kaishengit.shiro.realm;

import com.kaishengit.entity.Account;
import com.kaishengit.service.AccountService;
import com.kaishengit.shiro.token.JwtToken;
import com.kaishengit.utiil.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class JwtRealm extends AuthorizingRealm {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AccountService accountService;

    /**定义支持的token类型  当验证账户密码的时候就可以直接获取token
     *
     * @Author Reich
     * @Date: 2018/5/18 20:25
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**验证角色和权限
     *
     * @Author Reich
     * @Date: 2018/5/18 20:22
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**验证登录
     * 
     * @Author Reich
     * @Date: 2018/5/18 20:23  
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authenticationToken;
        //从jwtToken中获得token     header payload Signature
        String token = (String) jwtToken.getPrincipal();
        //根据token获得用户id
        Integer idFromToken = jwtUtil.getUserIdFromToken(token);
        Account account = accountService.finfAccountById(idFromToken);
        if (account == null){
            throw new UnknownAccountException("未知账户");
        } else {
            //验证token
            try {
                jwtUtil.verifyToken(token, account.getPassword(), idFromToken);
            } catch (Exception e) {
                e.printStackTrace();
                throw new AuthenticationException(e.getMessage(),e);
            }
        }
        return new SimpleAuthenticationInfo(token, token, getName());
    }
}
