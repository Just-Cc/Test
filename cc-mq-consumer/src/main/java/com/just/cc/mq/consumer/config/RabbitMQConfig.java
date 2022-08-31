package com.just.cc.mq.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Cc
 * @Date: 2022/8/25 15:11
 */
@Configuration
public class RabbitMQConfig {

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

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
        return BindingBuilder.bind(queue).to(topicExchange).with("ERROR");
    }

    @Bean(name="limitContainerFactory")
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(){
        SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(cachingConnectionFactory);
        factory.setPrefetchCount(1);
        return factory;
    }
}
