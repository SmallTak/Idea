package com.kaishengit.jms.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MessageConsumer {

    @JmsListener(destination = "weChat-queue")      //该方法内不仅可以接收String message字符串  也可接收Message对象
    public void queueMessageConsumer(Message message){
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("获取消息内容" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    // containerFactory = "jmsTopicListenerContainerFactory" 若不写则默认监听的是队列的工厂
    @JmsListener(destination = "hey-topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void topicMessageConsumer(Message message){
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("获得主题内容" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
