package com.kaishengit.springbootdemo.mq;

import com.kaishengit.springbootdemo.entity.Movie;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;

@Component
public class MyJmsMessageListener {

    @JmsListener(destination = "movie-queue")
    public void getUserFromMq(Movie movie){
        System.out.println("movie" + movie);
    }

    @JmsListener(destination = "springboot-queue")
    public void queueListener(TextMessage message){
        try {
            System.out.println("hello springboot mq" + message.getText());
            message.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("测试重试机制");
    }

    @JmsListener(destination = "springBoot-topic", containerFactory = "topidJmsListenerContainerFactory")
    public void topicListener(String message){
        System.out.println("springBoot topic" + message);

    }

}
