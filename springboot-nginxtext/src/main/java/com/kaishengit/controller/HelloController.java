package com.kaishengit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
public class HelloController {

    @GetMapping
    public String hello(HttpSession session, HttpServletRequest req){
        String ip = req.getHeader("X-Real-IP");
        return "hello,nginx" + session.getId() + ip;
    }

}
