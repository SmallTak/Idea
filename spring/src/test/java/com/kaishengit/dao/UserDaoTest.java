package com.kaishengit.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {

    @Test
    public void savetest(){
        //获取spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取userDao对象
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.save();
        UserDao userDao1 = (UserDao) applicationContext.getBean("userDao");
        userDao1.save();
        /*因为放入到spring容器中管理的bean默认为单例，所以创建类的对象的时候只调用一次构造方法，所以userdao和userdao1内存地址相同*/
        System.out.print(userDao == userDao1);

        //applicationContext.close();

    }

}
