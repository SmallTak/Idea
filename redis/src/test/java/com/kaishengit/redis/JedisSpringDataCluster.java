package com.kaishengit.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-data-redis-cluster.xml")
public class JedisSpringDataCluster {

    private RedisTemplate redisTemplatel;

    @Autowired
    public void setRedisTemplatel(RedisTemplate redisTemplatel){
        this.redisTemplatel = redisTemplatel;
        redisTemplatel.setKeySerializer(new StringRedisSerializer());
        redisTemplatel.setValueSerializer(new StringRedisSerializer());
    }

    @Test
    public void getString(){
        String str = (String) redisTemplatel.opsForValue().get("user:1");
        System.out.println(str);
    }

}
