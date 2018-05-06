package com.kaishengit.spring.quartz;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SendWeChat implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        String weCaht = (String) jobDataMap.get("weCaht");
        System.out.println("发送微信到" + weCaht);

    }

}
