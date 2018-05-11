package com.kaishengit.springbootdemo.config;

import com.kaishengit.springbootdemo.web.filter.MyFilter;
import com.kaishengit.springbootdemo.web.interceport.MyInterceport;
import com.kaishengit.springbootdemo.web.listener.MyListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletContextListener;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

    /**监听器
     *
     * @Author Reich
     * @Date: 2018/5/10 14:15
     */
   /* @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){

        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;

    }

    *//**拦截器
     *
     * @Author Reich
     * @Date: 2018/5/10 12:50
     *//*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceport()).addPathPatterns("/**");
    }

    *//**过滤器
     *
     * @Author Reich
     * @Date: 2018/5/10 14:07
     *//*
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;

    }*/


}
