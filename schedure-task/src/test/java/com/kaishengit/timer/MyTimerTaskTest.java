package com.kaishengit.timer;

import org.junit.Test;

import java.io.IOException;
import java.util.Timer;

public class MyTimerTaskTest {

    @Test
    public void test() throws IOException {

        MyTimerTask myTimerTask = new MyTimerTask();
        Timer timer = new Timer();
        //将任务延迟三秒
        //timer.schedule(myTimerTask, 5000);

        //在指定时间内去执行任务
        //timer.schedule(myTimerTask, new Date());

        //延迟3秒，并且每秒钟执行一次
        //timer.schedule(myTimerTask, 3000, 1000);


        //从指定时间开始执行，每隔几秒执行一次
        //timer.schedule(myTimerTask, new Date(), 2000);
        timer.scheduleAtFixedRate(myTimerTask, 0, 1000);
        System.in.read();

    }

}