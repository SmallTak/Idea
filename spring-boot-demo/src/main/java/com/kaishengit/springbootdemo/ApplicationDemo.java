package com.kaishengit.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration  以上三种同样可以代替
@SpringBootApplication
public class ApplicationDemo {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationDemo.class);

    }

}
