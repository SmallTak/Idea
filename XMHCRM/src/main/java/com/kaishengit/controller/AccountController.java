package com.kaishengit.controller;

import com.kaishengit.entity.TAccount;
import com.kaishengit.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String Login(HttpServletRequest req, HttpServletResponse resp){

        return "/account/login";

    }
    @PostMapping("/login")
    public String login(HttpServletRequest request , HttpServletResponse response, String mobile, String password, Model model){

        List<TAccount> tAccountList = accountService.findByMobile(mobile, password);
        TAccount account = tAccountList.get(0);


        String md5Password = DigestUtils.md5Hex(password + "QWSXZA$%$%((^%^FDEW))123");
        if (account != null && md5Password.equals(account.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            return "redirect:/product";
        }
        model.addAttribute("message","账号密码不匹配");
        return "account/login";
    }

    @GetMapping("/logout")
    public String editAccount(HttpServletRequest request){
        request.getSession().invalidate();
        return "account/login";
    }

}
