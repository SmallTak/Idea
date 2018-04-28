package com.kaishengit.tms.shiro;

import com.kaishengit.tms.entity.TicketStroe;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

@Component
public class ShiroUtil {

    public TicketStroe getCurrentAccount() {
        Subject subject = SecurityUtils.getSubject();
        return (TicketStroe) subject.getPrincipal();
    }

}
