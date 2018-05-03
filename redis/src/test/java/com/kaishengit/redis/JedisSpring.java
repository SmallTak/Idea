package com.kaishengit.redis;

import com.google.gson.Gson;
import com.kaishengit.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.sound.midi.VoiceStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class JedisSpring {

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void setString(){

        Jedis jedis = jedisPool.getResource();
        jedis.set("user:1", "tom");
        String s = jedis.get("user:1");
        System.out.println(s);
        jedis.close();

    }

    @Test
    public void setUser(){

        Jedis jedis = jedisPool.getResource();
        User user = new User("tak",22,"焦作");
        jedis.set("user:2", new Gson().toJson(user));
        String s = jedis.get("user:2");
        User userJson = new Gson().fromJson(s, User.class);
        System.out.println(s);
        System.out.println(userJson);
        jedis.close();
    }

}
