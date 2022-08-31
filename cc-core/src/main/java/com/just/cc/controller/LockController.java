package com.just.cc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static com.just.cc.constants.Constants.*;

/**
 * @Author: Cc
 * @Date: 2022/8/30 15:35
 */
@RestController
@RequestMapping(LOCK)
@Slf4j
public class LockController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JedisPool jedisPool;

    @GetMapping(REDIS + TEST + "/1")
    public void redisDistributed1() throws InterruptedException {
        log.info("进入分布式锁方法1");
        Jedis jedis = jedisPool.getResource();
        Long lock = jedis.setnx("lock", "lock");
        log.info("lock1:{}",lock);
        if(1 == lock){
            log.info("方法1已获取到锁");
            Thread.sleep(10000L);
            jedis.del("lock");
            log.info("锁已被方法1删除");
        }
    }

    @GetMapping(REDIS + TEST + "/2")
    public void redisDistributed2() throws InterruptedException {
        log.info("进入分布式锁方法2");
        Jedis jedis = jedisPool.getResource();
        Long lock = jedis.setnx("lock", "lock");
        log.info("lock2:{}",lock);
        if(1 == lock){
            log.info("方法2已获取到锁");
            Thread.sleep(5000L);
            jedis.del("lock");
            log.info("锁已被方法2删除");
        }
    }
}
