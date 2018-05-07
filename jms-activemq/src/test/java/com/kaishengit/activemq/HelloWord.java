package com.kaishengit.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.Destination;

import org.apache.activemq.RedeliveryPolicy;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

public class HelloWord {

    /**创建生产者
     *
     * @Author Reich
     * @Date: 2018/5/7 17:37
     */
    @Test
    public void creaeMessage(){

        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        try {
            //1.创建乱接工厂
            //ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            //自定义重试次数
            RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
            //设置重试次数
            redeliveryPolicy.setMaximumRedeliveries(3);
            //设置初次重试延迟时间，单位毫秒
            redeliveryPolicy.setInitialRedeliveryDelay(5000);
            //设置每次重试延迟时间，单位毫秒
            redeliveryPolicy.setRedeliveryDelay(5000);
            connectionFactory.setRedeliveryPolicy(redeliveryPolicy);

            //2.创建链接 并 开启
            connection = connectionFactory.createConnection();
            connection.start();

            //3.创建session(参数:是否提交事务  消息签收模式 .AUTO_ACKNOWLEDGE自动签收  CLIENT_ACKNOWLEDGE客户端签收)
            session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);

            //4.创建消息米低地
            Destination destination = session.createQueue("weChat-queue");

            //5.创建生产者
            producer = session.createProducer(destination);
            //使用持久模式
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            //6.发送消息
            TextMessage textMessage = session.createTextMessage("Hello:MQ15");
            producer.send(textMessage);
            //提交事务
            session.commit();
            //若不提交则需写回滚
//            session.rollback();

        } catch (JMSException ex) {
            ex.printStackTrace();
            try {
                if( session!= null) {
                    session.rollback();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }finally {
                //7. 释放资源
                close(session,connection,producer);
            }
        }
    }

    /**创建消费者
     *
     * @Author Reich
     * @Date: 2018/5/7 17:38
     */
    @Test
    public void consumerMessage() throws JMSException, IOException {

        //1.创建乱接工厂
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //自定义重试次数
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        //设置重试次数
        redeliveryPolicy.setMaximumRedeliveries(3);//第一次失败的异常+重试次数  共4次
        //设置初次重试延迟时间，单位毫秒
        redeliveryPolicy.setInitialRedeliveryDelay(5000);
        //设置每次重试延迟时间，单位毫秒
        redeliveryPolicy.setRedeliveryDelay(5000);
        connectionFactory.setRedeliveryPolicy(redeliveryPolicy);

        //2.创建链接 并 开启
        Connection  connection = connectionFactory.createConnection();
        connection.start();

        //3.创建session(参数:是否提交事务  消息签收模式 .AUTO_ACKNOWLEDGE自动签收  CLIENT_ACKNOWLEDGE客户端签收) 消息发布的时候为手动签收的 接收消息也应是手动的
       Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        //4.创建消息米低地
        Destination destination = session.createQueue("weChat-queue");

        //5.创建消费者
        MessageConsumer messageConsumer = session.createConsumer(destination);

        //6.获取消息
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                //从MQ中取出消息后的业务逻辑
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    if ("Hello:MQ15".equals(text)){
                        throw new RuntimeException("签收消息异常------------");
                    }
                    System.out.println("Message: -----> " + text);
                    //手动签收消息  若不签收则消息队列中则显示未出列
                    message.acknowledge();
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        //触发重试
                        session.recover();
                    } catch (JMSException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        System.in.read();

        //7. 释放资源
        messageConsumer.close();
        session.close();
        connection.close();

    }

    /**ActiveMQ.DLQ
     * 
     * @Author Reich
     * @Date: 2018/5/7 21:07
     */
    @Test
    public void consumerDlqMessage() throws JMSException, IOException {

        //1.创建乱接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //2.创建链接 并 开启
        Connection  connection = connectionFactory.createConnection();
        connection.start();

        //3.创建session(参数:是否提交事务  消息签收模式 .AUTO_ACKNOWLEDGE自动签收  CLIENT_ACKNOWLEDGE客户端签收) 消息发布的时候为手动签收的 接收消息也应是手动的
        final Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        //4.创建消息米低地
        Destination destination = session.createQueue("ActiveMQ.DLQ");

        //5.创建消费者
        MessageConsumer messageConsumer = session.createConsumer(destination);

        //6.获取消息
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                //从MQ中取出消息后的业务逻辑
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println("未发出成功的数据：" + text);
                    //手动签收消息  若不签收则消息队列中则显示未出列
                    message.acknowledge();
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        //触发重试
                        session.recover();
                    } catch (JMSException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        System.in.read();

        //7. 释放资源
        messageConsumer.close();
        session.close();
        connection.close();

    }

    private void close(Session session,Connection connection,MessageProducer producer) {
        if(producer != null) {
            try {
                producer.close();
            } catch (JMSException e) {
                e.printStackTrace();
            } finally {
                if(session != null) {
                    try {
                        session.close();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    } finally {
                        if(connection != null) {
                            try {
                                connection.close();
                            } catch (JMSException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    }

}
