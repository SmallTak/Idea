package com.kaishengit.tms.util;

import com.kaishengit.tms.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;


@Component
public class ShiroUtil {

   public Account getCurrAccount(){

        Subject subject = SecurityUtils.getSubject();
       return (Account) subject.getPrincipal();

   }
}
