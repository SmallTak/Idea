package com.kaishengit.tms;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class app {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring*.xml");
        classPathXmlApplicationContext.start();

        System.out.println("-------------------服务器启动完毕");
        System.in.read();

    }

}
