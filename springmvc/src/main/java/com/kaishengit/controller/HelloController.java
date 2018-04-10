package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "login1";
    }

    @PostMapping("/login")
    public String login(String username, String password){
        System.out.println(username + password);
        return "";
    }

}
