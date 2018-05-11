package com.kaishengit.springbootdemo.controller;

import com.kaishengit.springbootdemo.dao.UserDao;
import com.kaishengit.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public String hello(Model model){

        User user = new User();
        user.setName("Jack");
        user.setAddress("河南焦作");
        user.setAge(22);
        model.addAttribute("user", user);

       // userDao.save("hey", "men", "123123");

        //List<String> names = Arrays.asList("tom","jack","zhangsan");
        List<String> names = Arrays.asList();
        model.addAttribute("money",987993491L);
        model.addAttribute("names",names);
        model.addAttribute("age",23);
        model.addAttribute("message", "你好");
        model.addAttribute("id",1001);
//        return "user/home";
        return "user/index";
    }

}
