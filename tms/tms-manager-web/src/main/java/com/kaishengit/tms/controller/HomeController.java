package com.kaishengit.tms.controller;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 首页登录及登出的控制器
 * @Author Reich
 * @Date: 2018/4/12 19:43
 */
@Controller
public class HomeController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String index(HttpServletRequest req, RedirectAttributes redirectAttributes){

//        Cookie[] cookies = req.getCookies();
//        for(Cookie cookie : cookies) {
//            if("username".equals(cookie.getName())) {
//                redirectAttributes.addFlashAttribute("account",cookie.getValue());
//            }
//        }

        return "index";
    }

    @PostMapping("/")
    public String login(String accountMobile,
                        String password,
                        String remember,
                        HttpServletRequest request,
                        HttpSession session,
                        HttpServletResponse response,
                        RedirectAttributes redirectAttributes){

        //获得用户登录的ip
        String accountIp = request.getRemoteAddr();
        try {
            Account account = accountService.login(accountMobile, password, accountIp);
            //将登录成功后的用户放入到session
            session.setAttribute("account", account);

            //cookie
            if(StringUtils.isNotEmpty(remember)) {
                Cookie cookie = new Cookie("username",accountMobile);
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
            redirectAttributes.addFlashAttribute("account",account);

            //跳转到home页面
            return "redirect:/home";

        }catch (ServiceException e) {
            redirectAttributes.addFlashAttribute("phone",accountMobile);
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:/";
        }

    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest req){
        req.getSession().invalidate();

//        Cookie[] cookies = req.getCookies();
//        for(Cookie cookie : cookies) {
//            if("username".equals(cookie.getName())) {
//                req.setAttribute("username", cookie.getValue());
//            }
//        }
        return "redirect:/";
    }

    /**
     * 登录成功后重定向的首页
     * @return
     */
    @GetMapping("/home")
    public String home() {
        return "home";
    }


}
