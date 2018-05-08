package com.kaishengit.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SpringTopicListener2 implements MessageListener {

    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("----------->" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
