package com.kaishengit.tms.controller;

import com.kaishengit.tms.entity.Customer;
import com.kaishengit.tms.entity.StroeAccount;
import com.kaishengit.tms.entity.TicketStroe;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.fileStore.FastDfsUtil;
import com.kaishengit.tms.service.TicketStoreService;
import com.kaishengit.tms.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
@RequestMapping("/ticket/storage")
public class TicketServiceController {

    @Autowired
    private TicketStoreService ticketStoreService;

    @Autowired
    private FastDfsUtil fastDfsUtil;

    @Autowired
    private ShiroUtil shiroUtil;

    @GetMapping
    public String ticketHandle(){
        return "ticket/sales";
    }

    @PostMapping
    public String ticketHandle(Customer customer, String ticketNum, BigDecimal ticketPrice, RedirectAttributes redirectAttributes){
        TicketStroe ticketStroe = shiroUtil.getCurrentAccount();
        try {
            ticketStoreService.saveTicketCustomer(customer, ticketStroe,ticketNum,ticketPrice);
            redirectAttributes.addAttribute("message","年票办理成功");
        }catch (ServiceException e){
            e.printStackTrace();
            redirectAttributes.addAttribute("message",e.getMessage());
        }
        return "redirect:/ticket/storage";
    }


}
