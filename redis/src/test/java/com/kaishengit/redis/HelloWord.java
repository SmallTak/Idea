package com.kaishengit.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HelloWord {

    @Test
    public void hello(){
        Jedis jedis = new Jedis("192.168.142.13",6379);
        String pong = jedis.ping();
        System.out.println(pong);
        jedis.close();
    }
    @Test
    public void setString(){
        Jedis jedis = new Jedis("192.168.142.13",6379);
        for (int i = 0; i < 5; i++){
            jedis.set("name:"+i,"tom"+i);
        }
        Long strlen = jedis.strlen("name:1");
        System.out.println(strlen);
        Long rose = jedis.append("name:1", "rose");
        System.out.println(rose);
        List<String> tom = jedis.mget("name:1", "name:2");
        for (String t : tom){
            System.out.println(t);
        }

        jedis.close();
    }
    @Test
    public void lPush(){
        Jedis jedis = new Jedis("192.168.142.13",6379);
        jedis.rpush("user:1:name","he");
        Long llen = jedis.llen("user:1:name");

        jedis.lrem("user:1:name",2,"he");

        List<String> lrange1 = jedis.lrange("user:1:name", 0, llen);
        for (String str : lrange1){
            System.out.println(str);
        }
        jedis.close();
    }
    @Test
    public void lRange(){
        Jedis jedis = new Jedis("192.168.142.13",6379);
        jedis.close();
    }
    @Test
    public void zAdd(){
        Jedis jedis = new Jedis("192.168.142.13",6379);
        jedis.close();
    }
    @Test
    public void pook(){
        Jedis jedis = new Jedis("192.168.142.13",6379);
        jedis.close();
    }

}
