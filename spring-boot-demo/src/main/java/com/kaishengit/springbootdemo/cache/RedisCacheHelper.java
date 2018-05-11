package com.kaishengit.springbootdemo.cache;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheHelper {

   /* private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
    }

    *//**获得redis缓存
     *
     * @Author Reich
     * @Date: 2018/5/10 23:10
     *//*
    public Object get(String key, Class clazz){

        if (redisTemplate.hasKey(key)){
            String str = (String) redisTemplate.opsForValue().get(key);
            return new Gson().fromJson(str, clazz);
        }
        return null;
    }

    *//**添加redis缓存
     *
     * @Author Reich
     * @Date: 2018/5/10 23:16
     *//*
    public  void  set(String key, Object obj){
        String json = new Gson().toJson(obj);
        redisTemplate.opsForValue().set(key, json);
    }

    *//**添加缓存 并设置存活时间
     *
     * @Author Reich
     * @Date: 2018/5/10 23:16
     *//*
    public void set(String key, Object obj, long outTime){
        String json = new Gson().toJson(obj);
        redisTemplate.opsForValue().set(key, json,outTime, TimeUnit.SECONDS);
    }

    *//**删除缓存
     *
     * @Author Reich
     * @Date: 2018/5/10 23:11
     *//*
    public void delete(String key){
        redisTemplate.delete(key);
    }*/

}
