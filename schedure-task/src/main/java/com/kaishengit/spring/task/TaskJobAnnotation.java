package com.kaishengit.spring.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TaskJobAnnotation {

    @Scheduled(fixedRate = 100)
    @Async
    public void rateJob(){
        int id = new Random().nextInt(1000);
        System.out.println(Thread.currentThread().getName() + "rateJob start" + id );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("rateJob end" + id);
    }

    //@Scheduled(fixedDelay = 1000)
    public void delJob(){
        System.out.println("delJob");
    }

    @Scheduled(cron = "0/1 * * * * *")
    public void cronJob(){
        System.out.println("cronJob");
    }

}
