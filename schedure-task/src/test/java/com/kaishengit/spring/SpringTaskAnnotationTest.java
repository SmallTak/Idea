package com.kaishengit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-task-annotation.xml")
public class SpringTaskAnnotationTest {

    @Test
    public void start() throws IOException {
        System.out.println("spring task start...");
        System.in.read();
    }

}
