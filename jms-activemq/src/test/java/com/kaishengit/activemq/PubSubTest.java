package com.kaishengit.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import sun.misc.Cache;

import javax.jms.*;
import java.io.IOException;

public class PubSubTest {

    /**消息发布者
     *
     * @Author Reich
     * @Date: 2018/5/8 11:34
     */
    @Test
    public void createTopic() throws JMSException {
        //1.创建乱接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //2.创建链接 并 开启
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //3.创建session(参数:是否提交事务  消息签收模式 .AUTO_ACKNOWLEDGE自动签收  CLIENT_ACKNOWLEDGE客户端签收)
        final Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        //4.创建消息目的地
        Topic topic = session.createTopic("hey-topic");

        //5.创建生产者
        MessageProducer producer = session.createProducer(topic);

        //6.发送消息
        TextMessage textMessage = session.createTextMessage("hey,Topic - 1");
        producer.send(textMessage);

        //7.释放资源
        producer.close();
        session.close();
        connection.close();

    }

    /**消息订阅者
     *
     * @Author Reich
     * @Date: 2018/5/8 11:35
     */
    @Test
    public void customerTopic() throws JMSException, IOException {

        //1.创建链接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //2.创建链接并开启
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //3.创建session （是否需要事务，消息的签收模式：AUTO_ACKNOWLEDGE自动签收）
        final Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        //4.创建消息主题
        Topic topic = session.createTopic("hey-topic");

        //5.创建主题的消费者
        MessageConsumer consumer = session.createConsumer(topic);

        //6.配置消息的监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();

        //7. 释放资源
        consumer.close();
        session.close();
        connection.close();


    }

}
