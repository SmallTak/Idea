package com.kaishengit.springMq;

import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-jms-topic3.xml")
public class TopicTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void sendMessageToTopic() throws InterruptedException {
        while (true){
            //jmsTemplate.send()该方法的重载有三个第一个和第三个一般用作队列，第二个一般用作为主题(目的地对象destination)
            //Destination该接口的实例有ActiveMQTopic和ActiveMQQueue
            //指定topic目的地
            Destination destination = new ActiveMQTopic("hey-topic");
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("hey spring + jms" + new Date().getTime());
                }
            });
            Thread.sleep(2000);
        }

       //使用配置文件中的默认地址
        /*jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hey spring + jms 1");
            }
        });*/

    }

    @Test
    public void consumerMessage() throws IOException {
        System.out.println("Spring start...");
        System.in.read();
    }


}
