package com.kaishengit.springbootdemo.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    //使用该map是为了在application.properties配置中便于配置redis自定义的缓存生存周期
    private Map<String, Long> expires;

    public Map<String, Long> getExpires() {
        return expires;
    }

    public void setExpires(Map<String, Long> expires) {
        this.expires = expires;
    }

}
