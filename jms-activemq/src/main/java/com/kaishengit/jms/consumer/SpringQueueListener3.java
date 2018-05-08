package com.kaishengit.jms.consumer;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

public class SpringQueueListener3 implements SessionAwareMessageListener{

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        String text = textMessage.getText();

        if(text.startsWith("Hey,spring")) {
            //   session.recover();
            throw new RuntimeException("故意抛出的异常:" + text);
        }
    }
}
