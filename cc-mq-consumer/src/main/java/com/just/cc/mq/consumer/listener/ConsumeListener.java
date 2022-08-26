package com.just.cc.mq.consumer.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: Cc
 * @Date: 2022/8/25 15:24
 */
@Component
public class ConsumeListener {

    @RabbitListener(queues = "topic-queue")
    public void consumerFirst(String msg, Channel channel, Message message) throws IOException, InterruptedException {
        channel.basicQos(0,1,false);
        Thread.sleep(4500L);
        System.out.println("consumerFirst 接收到消息：" + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

    @RabbitListener(queues = "topic-queue")
    public void consumerSecond(String msg, Channel channel, Message message) throws IOException, InterruptedException {
        channel.basicQos(0,1,true);
        Thread.sleep(2000L);
        System.out.println("consumerSecond 接收到消息：" + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
