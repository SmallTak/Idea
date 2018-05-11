package com.kaishengit.springbootdemo.config;

import com.kaishengit.springbootdemo.prop.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class CacheConfig {

    @Autowired
    private RedisProperties redisProperties;

   /* @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager();
    }*/

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        //将redis的键添加前缀 防止命名冲突
        redisCacheManager.setUsePrefix(true);
        //添加缓存的生存周期
        redisCacheManager.setExpires(redisProperties.getExpires());
        return redisCacheManager;
    }
}
