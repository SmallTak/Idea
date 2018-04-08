package com.kaishengit.controller;

import com.kaishengit.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/new")
    public String saveCustomer(){
        return "/customer/new";
    }

    @PostMapping("/new")
//    public String saveCustomer(String name, String address){
    public String saveCustomer(Customer customer, String leve){
        System.out.println("form name -->" + customer.getName() + "\nfrom address->" + customer.getAddress() + "\nleve ->" + leve);
        return "redirect:/customer/new";
    }

    //向视图传值a
    @GetMapping("/{id:\\d+}")
    public String showCustomer(@PathVariable Integer id, Model model){
        System.out.println("customerId:" + id);
        model.addAttribute("customerId",id);
        return "/customer/show";
    }
    //向视图传值b，通过正则表达式来规定url中参数的规范
    @GetMapping("/{typeName:d-\\d+}/{customerId:\\d+}")
    public ModelAndView showCustomerByType(@PathVariable String typeName,
                                            @PathVariable Integer customerId){

//        ModelAndView modelAndView = new ModelAndView();
//        //设置跳转的视图名称
//        modelAndView.setViewName("/customer/show");

        ModelAndView modelAndView = new ModelAndView("/customer/show");
        //设置传递的参数
        modelAndView.addObject("customerId",customerId);
        modelAndView.addObject("typeName",typeName);
        return modelAndView;

    }


}
