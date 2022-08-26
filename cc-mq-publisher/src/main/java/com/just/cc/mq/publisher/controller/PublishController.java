package com.just.cc.mq.publisher.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.just.cc.constants.Constants.*;

/**
 * @Author: Cc
 * @Date: 2022/8/25 15:23
 */
@RestController
@RequestMapping(RABBIT_BASEURL)
public class PublishController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(TEST)
    public void publish(){
        for (int i = 1; i < 11; i++) {
            String msg = "这是一条测试MQ消息" + i;
            rabbitTemplate.convertAndSend("boot-topic-exchange","TEST",msg);
        }
    }
}
