package com.kaishengit.controller;

import com.kaishengit.entity.Account;
import com.kaishengit.mapper.AccountMapper;
import com.kaishengit.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String Login(HttpServletRequest req, HttpServletResponse resp){

        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies) {
            if("username".equals(cookie.getName())) {
                req.setAttribute("username", cookie.getValue());
            }
        }

        return "account/login";

    }


    @PostMapping("/login")
    public String login(HttpServletRequest request , HttpServletResponse response, String mobile, String password, String remember){

        Account account = accountService.findByMobile(mobile, password);

        HttpSession session = request.getSession();
        session.setAttribute("account", account);

        if(StringUtils.isNotEmpty(remember)) {
            Cookie cookie = new Cookie("username",mobile);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 30);
            cookie.setHttpOnly(true);

            response.addCookie(cookie);
        } else {
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie : cookies) {
                if("username".equals(cookie.getName())) {
                    cookie.setDomain("localhost");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);

                    response.addCookie(cookie);
                }
            }
        }

        String md5Password = DigestUtils.md5Hex(password + "QWSXZA$%$%((^%^FDEW))123");
        if (account != null && md5Password.equals(account.getPassword())){
            return "redirect:/product";
        }
        return "account/login";
    }

}
