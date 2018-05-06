package com.kaishengit.spring.task;

public class MySpringTask implements Runnable {

    public void run() {
        System.out.println("job begin-----------------------------");
        System.out.println("hello spring thread pool...." + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("job end-----------------------------");
    }
}
