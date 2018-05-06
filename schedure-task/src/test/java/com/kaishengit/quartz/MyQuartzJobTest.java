package com.kaishengit.quartz;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

public class MyQuartzJobTest {

    @Test
    public void simpleTrigger() throws SchedulerException, IOException {

        //1.定义任务

        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class).build();

        //2.定义触发的形式
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        simpleScheduleBuilder.withIntervalInSeconds(5);
        simpleScheduleBuilder.repeatForever();

        //3.通过触发的形式定义触发器
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(simpleScheduleBuilder).build();

        //4.创建调度者对象
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //调度任务
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        System.in.read();

    }

    @Test
    public void cronTrigger() throws SchedulerException, IOException {
        //1. 定义任务
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("putPhoneNum", "13461346731");

        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class).setJobData(jobDataMap)
                .build();
        //2. 定义触发的形式
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ? ");
        //3. 通过触发形式创建触发器
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();
        //4. 创建任务调度者对象
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        //5. 调度任务
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

        System.in.read();

    }

}