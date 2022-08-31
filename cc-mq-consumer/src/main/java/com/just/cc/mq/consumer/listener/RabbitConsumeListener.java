package com.just.cc.mq.consumer.listener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: Cc
 * @Date: 2022/8/25 15:24
 */
@Component
@Slf4j
public class RabbitConsumeListener {

    private int one = 0;
    private int two = 0;
    private int three = 0;

    @RabbitListener(queues = "topic-queue", containerFactory = "limitContainerFactory")
    public void consumerFirst(String msg, Channel channel, Message message) throws IOException, InterruptedException {
        /*DefaultConsumer consumer = new DefaultConsumer(channel);
        channel.basicConsume("topic-queue",false, consumer);
        channel.basicQos(1);*/
        Thread.sleep(4500L);
        //System.out.println("consumerFirst 接收到消息：" + msg);
        one++;
        System.out.println("one: " + one);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    @RabbitListener(queues = "topic-queue", containerFactory = "limitContainerFactory")
    public void consumerSecond(String msg, Channel channel, Message message) throws IOException, InterruptedException {
        /*DefaultConsumer consumer = new DefaultConsumer(channel);
        channel.basicConsume("topic-queue",false, consumer);
        channel.basicQos(1);*/
        Thread.sleep(2000L);
        //System.out.println("consumerSecond 接收到消息：" + msg);
        two++;
        System.out.println("two: " + two);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    @RabbitListener(queues = "topic-queue", containerFactory = "limitContainerFactory")
    public void consumerThird(String msg, Channel channel, Message message) throws IOException, InterruptedException {
        /*DefaultConsumer consumer = new DefaultConsumer(channel);
        channel.basicConsume("topic-queue",false, consumer);
        channel.basicQos(1);*/
        Thread.sleep(1000L);
        //System.out.println("consumerThird 接收到消息：" + msg);
        three++;
        System.out.println("three: " + three);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
