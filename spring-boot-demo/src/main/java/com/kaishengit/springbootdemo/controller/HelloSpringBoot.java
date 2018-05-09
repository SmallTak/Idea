package com.kaishengit.springbootdemo.controller;

import com.kaishengit.springbootdemo.config.QiNiuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {

    @Autowired
    private QiNiuConfig qiNiuConfig;

    @GetMapping("/hello")
    public String heyMen(){
        System.out.println("Ak" + qiNiuConfig.getAk() + "---SK" + qiNiuConfig.getSk());
        return "hello springboot";

    }

}
