package com.kaishengit;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/*以下注解为替代配置文件*/
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Application {
}
