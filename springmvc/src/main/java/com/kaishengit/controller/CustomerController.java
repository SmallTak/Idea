package com.kaishengit.controller;

import com.kaishengit.entity.Customer;
import com.kaishengit.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public String list(Model model,
                       @RequestParam(name = "pageNo",defaultValue = "1") Integer pageNo){
                        //上面相当于判断p的值是否为null，为null的话就给一个默认值

        model.addAttribute("pageNo",pageNo);
        return "/customer/list";
    }

    @GetMapping("/new")
    public String saveCustomer() throws IOException {
//        if(1==1){
//            throw new IOException();
//        }
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

//        if (id.equals(1024)){
//            throw new NotFoundException();
//        }

        model.addAttribute("customerId",id);
        return "/customer/show";
    }
    //向视图传值b，通过正则表达式来规定url中参数的规范
    @GetMapping("/{typeName:d-.+}/{customerId:\\d+}")
    public ModelAndView showCustomerByType(@PathVariable String typeName,
                                            @PathVariable Integer customerId) throws UnsupportedEncodingException {

        //a解决url中含有中文乱码     b在tomcat插件的<configuration>节点下添加<encoding>UTF-8</encoding>同样可以解决中文乱码
        //typeName = new String(typeName.getBytes("ISO8859-1"),"UTF-8");
//        ModelAndView modelAndView = new ModelAndView();
//        //设置跳转的视图名称
//        modelAndView.setViewName("/customer/show");

        ModelAndView modelAndView = new ModelAndView("/customer/show");
        //设置传递的参数
        modelAndView.addObject("customerId",customerId);
        modelAndView.addObject("typeName",typeName);
        return modelAndView;
    }

    //idea工具栏tools -> test restful可进行post请求测试
    @PostMapping(value = "/save",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String saveAjax(){
        return "保存成功";
    }

    @GetMapping("/{id}.json")
    @ResponseBody
    public Customer showCustomer(@PathVariable Integer id){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("退");
        customer.setAddress("退到");
        return customer;
    }

    @GetMapping("/all.json")
    @ResponseBody
    public List<Customer> showAll(){

        List<Customer> customerList = Arrays.asList(
                new Customer(1001,"You","低头不说"),
                new Customer(13,"where","低"),
                new Customer(14,"what","说")
        );
    return customerList;
    }


}
