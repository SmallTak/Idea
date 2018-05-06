package com.kaishengit.spring;

import com.kaishengit.spring.quartz.SendWeChat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-quartz.xml","classpath:spring-datasource.xml"})
public class SpringQuartzTest {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Test
    public void run() throws IOException {
        System.out.println("Spring start....");

        System.in.read();
    }

    @Test
    public void addJob() throws SchedulerException, IOException {

        JobDataMap dataMap = new JobDataMap();
        dataMap.put("weChat", "朱日和");

        JobDetail jobDetail = JobBuilder.newJob(SendWeChat.class)
                //定义任务的唯一性（根据名称和组名定义的）
                .withIdentity("weCaht:朱日和","朱日和演习基地")
                .setJobData(dataMap)
                .build();

        String cron = "0 37 18  * * ? *";
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(cronScheduleBuilder).build();

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        System.in.read();

    }

    @Test
    public void deleteTask() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.deleteJob(new JobKey("weCaht:朱日和","朱日和演习基地"));
    }

}
