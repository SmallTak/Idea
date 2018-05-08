package com.kaishengit.springMq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.swing.*;
import java.io.IOException;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-jms-queue4.xml")
public class QueueTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**发送消息
     *
     * @Author Reich
     * @Date: 2018/5/8 14:01
     */
    @Test
    public void sendMessageToQueue() throws InterruptedException, IOException {
        while (true){
            //send()中可指定消息发布的地址"weChat-queue",
            jmsTemplate.send( new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("Hey,spring+jms" + new Date().getTime());
                }
            });
            //System.in.read();
            Thread.sleep(2000);
        }

    }

    @Test
    public void consumerMessage() throws IOException {

        System.out.println("spring start...");
        System.in.read();

    }

}
