package com.kaishengit.dao;

import com.kaishengit.baseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends baseTestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void save(){
        userDao.save();
    }


   /* @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
       UserDao userDao = (UserDao) applicationContext.getBean("userDao");
    }*/


}
