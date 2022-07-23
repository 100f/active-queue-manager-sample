package dev.caio.study.queue.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${spring.rabbitmq.queue-name}")
    private String queue;

    @Value("${spring.rabbitmq.exchange-name}")
    private String exchange;

    @Value("${spring.rabbitmq.message-name}")
    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    public Exchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding buildQueueToExchangeBinding(Queue queue, Exchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(routingKey)
                .noargs();
    }

    @Bean
    public MessageConverter getMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
