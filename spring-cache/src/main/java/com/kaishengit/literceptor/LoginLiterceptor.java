package com.kaishengit.literceptor;

import com.kaishengit.entity.Account;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginLiterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        if (uri.startsWith("/static") || uri.equals("/favicon.ico") || uri.startsWith("/account/")){
            return true;
        }

       /* HttpSession session = request.getSession();
        if (session.getAttribute("account") == null){
            response.sendRedirect("/account/");
        }*/

        return true;
    }
}
