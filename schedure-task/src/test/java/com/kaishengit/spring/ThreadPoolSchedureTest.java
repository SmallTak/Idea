package com.kaishengit.spring;

import com.kaishengit.spring.task.MySpringTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-task.xml")
public class ThreadPoolSchedureTest {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Test
    public void test() throws IOException {

        MySpringTask mySpringTask = new MySpringTask();
        //立即执行任务
        //taskScheduler.execute(mySpringTask);

        //在指定时间执行任务
        //taskScheduler.schedule(mySpringTask, new Date(System.currentTimeMillis() + 2000));

        //延迟循环执行任务          上一件事完成之后（从结束时间开始）间隔多久去做另外一件事
        //taskScheduler.scheduleWithFixedDelay(mySpringTask, 1000);

        //从指定时间开始延迟循环执行任务
        //taskScheduler.scheduleWithFixedDelay(mySpringTask, new Date(), 1000);

        // 按照固定间隔执行任务      从上一件事开始做时开始计时  结束下一件事开始
        //taskScheduler.scheduleAtFixedRate(mySpringTask, 1000);

        //spring同样支持cron表达式
        taskScheduler.schedule(mySpringTask,new CronTrigger("0/1 * * * * ?"));

        System.in.read();

    }

}
