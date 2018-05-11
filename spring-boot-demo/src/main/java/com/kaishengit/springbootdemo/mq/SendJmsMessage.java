package com.kaishengit.springbootdemo.mq;

import com.kaishengit.springbootdemo.entity.Movie;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class SendJmsMessage {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**发送消息
     *
     * @Author Reich
     * @Date: 2018/5/11 16:43
     */
    public void sendMessageQueue(String message){

        ActiveMQQueue activeMQQueue = new ActiveMQQueue("springboot-queue");
        jmsTemplate.send(activeMQQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    /**发送消息到主题
     *
     * @Author Reich
     * @Date: 2018/5/11 16:56
     */
    public void sendMessageTopic(String message){

        ActiveMQTopic activeMQTopic = new ActiveMQTopic("springBoot-topic");
        jmsTemplate.send(activeMQTopic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hey men topic");
            }
        });
    }
    
    /**发送java对象到队列
     * 
     * @Author Reich
     * @Date: 2018/5/11 21:44  
     */
    public void sendMovieToQueue(Movie movie){
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("movie-queue");
        jmsTemplate.convertAndSend(activeMQQueue, movie);
    }

}
