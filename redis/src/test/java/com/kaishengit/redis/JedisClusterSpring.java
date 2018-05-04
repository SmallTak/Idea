package com.kaishengit.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-jedis-cluster.xml")
public class JedisClusterSpring {

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void getName() throws IOException {

        String s = jedisCluster.get("user:1");
        System.out.println(s);
        jedisCluster.close();

    }

}
