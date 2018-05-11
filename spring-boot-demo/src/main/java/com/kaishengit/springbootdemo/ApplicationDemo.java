package com.kaishengit.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration  以上三种同样可以代替
@SpringBootApplication
@EnableJms
public class ApplicationDemo {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationDemo.class);
    }

}
