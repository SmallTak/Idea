package com.kaishengit.springbootdemo.controller;

import com.kaishengit.springbootdemo.entity.Movie;
import com.kaishengit.springbootdemo.mq.SendJmsMessage;
import com.kaishengit.springbootdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsController {

    @Autowired
    private SendJmsMessage sendJmsMessage;

    @Autowired
    private MovieService movieService;

    /**发送消息到队列
     *
     * @Author Reich
     * @Date: 2018/5/11 16:58
     */
    @GetMapping("/jms/queue")
    public String sendToQueue(){
        sendJmsMessage.sendMessageQueue("hey" + System.currentTimeMillis());
        return "success";
    }

    /**发送消息到主题
     *
     * @Author Reich
     * @Date: 2018/5/11 16:58
     */
    @GetMapping("/jms/topic")
    public String sengMessageTopic(){
        sendJmsMessage.sendMessageTopic("hello" + System.currentTimeMillis());
        return "success";
    }

    /**将java对象发送到队列
     *
     * @Author Reich
     * @Date: 2018/5/11 21:47
     */
    @GetMapping("/jms/movie")
    public String sendMovieToQueue(){

        Movie movie = movieService.selectMovieById(121);
        sendJmsMessage.sendMovieToQueue(movie);
        return "send java obj to queue";
    }

}
