package com.just.cc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @Author: Cc
 * @Date: 2022/8/31 14:05
 */
@Configuration
public class JedisConfig {

    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Bean
    public JedisPool JedisPool(){
        //这里使用默认的Host和Port，指向localhost
        JedisPool pool = new JedisPool();
        return pool;
    }
}
