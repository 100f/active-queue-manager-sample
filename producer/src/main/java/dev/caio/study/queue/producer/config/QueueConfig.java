package dev.caio.study.queue.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class QueueConfig {

    @Value("${spring.rabbitmq.queue-name}")
    private String queueName;

    @Value("${spring.rabbitmq.exchange-name}")
    private String exchangeName;

    @Value("${spring.rabbitmq.message-name}")
    private String routingKey;

    @Bean
    public Queue getQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    public Exchange getExchange() {
        return ExchangeBuilder.directExchange(exchangeName).build();
    }

    @Bean
    public Binding buildBinding() {
        return BindingBuilder
                .bind(getQueue())
                .to(getExchange())
                .with(routingKey)
                .noargs();
    }

}
