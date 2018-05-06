package com.kaishengit.tms.quartzJobs;

import com.kaishengit.tms.entity.Ticket;
import com.kaishengit.tms.service.TicketService;
import org.joda.time.DateTime;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 检查年票是否过期  在每天的0:0:1
 * @Author Reich
 * @Date: 2018/5/6 22:04
 */
public class CheckTicketJob implements Job {

    private Logger logger = LoggerFactory.getLogger(CheckTicketJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            //1.获取spring容器
            ApplicationContext applicationContext = (ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContext");

            //2.从容器中获得ticketService对象
            TicketService ticketService = applicationContext.getBean(TicketService.class);

            //3.获得所有已经销售的年票
            List<Ticket> ticketList = ticketService.findAllTicketByTicketState(Ticket.TICKET_STATE_SALE);

            //创建出一个空list集合  用于存放已过期的年票
            List<Ticket> outTimeTicket = new ArrayList<>();

            for (Ticket ticket : ticketList){

                //获取当前已过期的年票
                Date end = ticket.getTicketValidityEnd();

                DateTime dateTime = new DateTime(end.getTime());
                //舍弃时分秒
                dateTime = dateTime.withTime(0,0,0,0);
                dateTime = dateTime.plusDays(1);

                //若年票有效期在当前时刻之前则视为已过期
                if (dateTime.isBeforeNow()){
                    ticket.setTicketState(Ticket.TICKET_STATE_OUT_DATE);
                    outTimeTicket.add(ticket);
                }
            }
            if(!outTimeTicket.isEmpty()) {
                ticketService.batchUpdateTicketState(outTimeTicket);
                logger.info("今日过期年票 {} 张 ",outTimeTicket.size());
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
            throw new RuntimeException("执行定时任务异常",e);
        }

    }

}
