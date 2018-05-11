package com.kaishengit.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration  以上三种同样可以代替
@SpringBootApplication
public class ApplicationDemo {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationDemo.class);
    }

}
