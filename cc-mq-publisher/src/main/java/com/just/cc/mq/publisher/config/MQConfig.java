package com.just.cc.mq.publisher.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Cc
 * @Date: 2022/8/25 15:11
 */
@Configuration
public class MQConfig {

    /**
     * 1、创建exchange topic
     */
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange("boot-topic-exchange", true, false);
    }

    /**
     * 2、创建queue
     * @return
     */
    @Bean
    public Queue getQueue(){
        return new Queue("topic-queue",true,false,false,null);
    }

    /**
     * 3、绑定
     * @param topicExchange
     * @param queue
     * @return
     */
    @Bean
    public Binding geteBinding(TopicExchange topicExchange, Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with("TEST");
    }
}
