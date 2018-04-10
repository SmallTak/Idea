package com.kaishengit.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        //System.out.println(url);
        //对于静态资源的请求直接放行
        if(url.startsWith("/static") || url.equals("/favicon.ico")){
            return true;
        }
        //login页面直接放行
        if("".equals(url) || "/".equals(url)){
            return true;
        }

        //当用户在没有登录的情况下去访问敏感页面的时候会直接跳转到登录页面
       /* HttpSession session = request.getSession();
        if(session.getAttribute("zhanshan") == null){
            response.sendRedirect("/");
        }*/

        return true;

    }
}
