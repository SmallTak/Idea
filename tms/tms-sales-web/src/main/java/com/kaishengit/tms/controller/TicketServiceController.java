package com.kaishengit.tms.controller;

import com.kaishengit.tms.entity.Customer;
import com.kaishengit.tms.entity.StroeAccount;
import com.kaishengit.tms.entity.TicketStroe;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.fileStore.FastDfsUtil;
import com.kaishengit.tms.service.TicketCustomerService;
import com.kaishengit.tms.service.TicketStoreService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/ticket/storage")
public class TicketServiceController {

    @Autowired
    private TicketCustomerService ticketCustomerService;

    @Autowired
    private TicketStoreService ticketStoreService;

    @Autowired
    private FastDfsUtil fastDfsUtil;

    @GetMapping
    public String ticketHandle(){
        return "ticket/sale";
    }

    @PostMapping
    public String ticketHandle(Customer customer, Model model){
        try {
            Subject subject = SecurityUtils.getSubject();
            TicketStroe ticketStroe = (TicketStroe) subject.getPrincipal();
            StroeAccount stroeAccount = ticketStoreService.findStroeAccountById(ticketStroe.getId());
            ticketCustomerService.saveTicketCustomer(customer, stroeAccount);
            model.addAttribute("message","年票办理成功");
            return "ticket/sale";
        }catch (ServiceException e){
            model.addAttribute("message","年票库存不足");
            return "redirect:/";
        }

    }


}
