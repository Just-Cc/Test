package com.just.cc.mq.consumer.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Cc
 * @Date: 2022/8/29 18:46
 */
@Component
@RocketMQMessageListener(topic = "cc-topic", consumerGroup = "rocketConsumeTwo")
public class RocketConsumeListener2 implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("message2:" + s);
    }
}
