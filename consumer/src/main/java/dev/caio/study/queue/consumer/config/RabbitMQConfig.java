package dev.caio.study.queue.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${spring.rabbitmq.queue-name}")
    private String queueName;

    @Value("${spring.rabbitmq.message-name}")
    private String routingKey;

    @Value("${spring.rabbitmq.connection-uri}")
    private String uri;

    @Bean
    public Queue listeningQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        final CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUri(uri);
        return connectionFactory;
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer() {
        final SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setQueues(listeningQueue());
        listenerContainer.setConnectionFactory(connectionFactory());
        return listenerContainer;
    }

}
