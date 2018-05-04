package com.kaishengit.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-jedis-cluster.xml")
public class JedisClusterTest {

    private JedisCluster jedisCluster;

    @Before
    public void before(){

        //连接池配置
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(10);
        genericObjectPoolConfig.setMinIdle(5);

        //集群主机集合
        Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
        hostAndPorts.add(new HostAndPort("192.168.1.14",6001));
        hostAndPorts.add(new HostAndPort("192.168.1.14",6002));
        hostAndPorts.add(new HostAndPort("192.168.1.14",6003));
        hostAndPorts.add(new HostAndPort("192.168.1.14",6004));
        hostAndPorts.add(new HostAndPort("192.168.1.14",6005));
        hostAndPorts.add(new HostAndPort("192.168.1.14",6006));

        jedisCluster = new JedisCluster(hostAndPorts, genericObjectPoolConfig);

    }

    @Test
    public void setString() throws IOException {

        String set = jedisCluster.set("user:1","hey men~");
        System.out.println(set);
        jedisCluster.close();

    }

    @Test
    public void getString() throws IOException {

        String s = jedisCluster.get("user:1");
        System.out.println(s);
        jedisCluster.close();
    }

}
