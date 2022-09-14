package com.just.cc.mq.publisher.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.tools.json.JSONUtil;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.JacksonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static com.just.cc.constants.Constants.*;

/**
 * @Author: Cc
 * @Date: 2022/8/25 15:23
 */
@RestController
@RequestMapping(MQ)
public class PublishController {

    private String ROCKET_TOPIC = "cc-topic";

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping(RABBIT + TEST)
    public void rabbitPublish(){
        for (int i = 1; i < 101; i++) {
            String msg = "这是一条测试RabbitMQ消息" + i;
            rabbitTemplate.convertAndSend("boot-topic-exchange","TEST",msg);
        }
    }

    @GetMapping(ROCKET + TEST)
    public void rocketPublish(){
        for (int i = 1; i < 11; i++) {
            String msg = "这是一条测试RocketMQ消息" + i;
            rocketMQTemplate.convertAndSend(ROCKET_TOPIC,msg);
        }
    }
}
