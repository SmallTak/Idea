package com.kaishengit.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {

    @GetMapping("/hello")
    public String heyMen(){

        return "hello springboot";

    }

}
