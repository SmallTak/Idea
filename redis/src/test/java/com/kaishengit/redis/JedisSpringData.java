package com.kaishengit.redis;

import com.google.gson.Gson;
import com.kaishengit.entity.User;
import com.kaishengit.entity.UserText;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-data-redis.xml")
public class JedisSpringData {

    private RedisTemplate redisTemplate;

    @Autowired
    public void serRedisTemplate(RedisTemplate redisTemplate){
       this.redisTemplate = redisTemplate;
       this.redisTemplate.setKeySerializer(new StringRedisSerializer());
     //  this.redisTemplate.setValueSerializer(new StringRedisSerializer());
       this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
    }

    @Test
    public void setSteing(){
        redisTemplate.opsForValue().set("user:3","heyman");
    }

    @Test
    public void getString(){
        String user = (String) redisTemplate.opsForValue().get("user:3");
        System.out.println(user);
    }

    @Test
    public void saveUser(){
        User user = new User("rose", 23, "北京市朝阳区");
        //若redisTemplate构造方法中不使用Jackson2JsonRedisSerializer的话同样可以使用
        //redisTemplate.opsForValue().set("user:3", new Gson().toJson(user));
        redisTemplate.opsForValue().set("user:3", user);
    }

    @Test
    public void getUser(){
        User user = (User) redisTemplate.opsForValue().get("user:3");
        System.out.println(user);
    }

    @Test
    public void setUserText(){

        UserText userText = new UserText("jack","123123443","1048388981@qq,com","123123");
        String s = DigestUtils.md5Hex(userText.getPassword());
        System.out.println(s);
        redisTemplate.opsForValue().set(s,userText);

    }

    @Test
    public void getUserText(){

        UserText userText = (UserText) redisTemplate.opsForValue().get("4297f44b13955235245b2497399d7a93");


    }


}
