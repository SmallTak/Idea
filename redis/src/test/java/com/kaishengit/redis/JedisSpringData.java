package com.kaishengit.redis;

import com.google.gson.Gson;
import com.kaishengit.entity.User;
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

}
