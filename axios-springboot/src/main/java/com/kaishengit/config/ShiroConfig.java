package com.kaishengit.config;

import com.kaishengit.shiro.filter.JwtFilter;
import com.kaishengit.shiro.realm.JwtRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm(){
        return new JwtRealm();
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //使用自己定义realm
        defaultWebSecurityManager.setRealm(realm);
        //关闭session自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        defaultWebSecurityManager.setSubjectDAO(subjectDAO);
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        // 添加过滤器并且取名为jwt
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new  JwtFilter());

        //放入到shiroFilterFactoryBean中
        shiroFilterFactoryBean.setFilters(filterMap);

        //设置URL的过滤规则
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("/login","anon");
        map.put("/**","jwt");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

}
