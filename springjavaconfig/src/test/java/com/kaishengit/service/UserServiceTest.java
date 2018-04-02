package com.kaishengit.service;

import com.kaishengit.baseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends baseTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void saveTest(){
       /* ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService.getClass().getName());*/
        userService.saveTest();
    }

}
