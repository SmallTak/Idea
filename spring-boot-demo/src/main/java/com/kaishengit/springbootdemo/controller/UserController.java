package com.kaishengit.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String hello(Model model){

        List<String> names = Arrays.asList("tom","jack","zhangsan");

        model.addAttribute("names",names);
        model.addAttribute("age",23);
        model.addAttribute("message", "你好");
        model.addAttribute("id",1001);
        return "user/home";

    }

}
