package com.kaishengit.timer;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "Hello,Message,start");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Hello,Message,end");
    }
}
