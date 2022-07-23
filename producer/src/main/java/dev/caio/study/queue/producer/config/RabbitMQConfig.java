package dev.caio.study.queue.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${spring.rabbitmq.connection-uri}")
    private String uri;

    @Value("${spring.rabbitmq.queue-name}")
    private String queueName;

    @Value("${spring.rabbitmq.message-name}")
    private String routingKey;

    @Value("${spring.rabbitmq.exchange-name}")
    private String exchangeName;

    @Bean
    Queue validadorQueue() {
        return QueueBuilder.durable(queueName).build();
    }

    @Bean
    Exchange validadorExchange() {
        return ExchangeBuilder.directExchange(exchangeName).durable(true).build();
    }

    @Bean
    Binding bindValidadorExchangeToQueue() {
        return BindingBuilder.bind(validadorQueue()).to(validadorExchange()).with(routingKey).noargs();
    }
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUri(uri);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate producerTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange(exchangeName);
        template.setRoutingKey(routingKey);
        return template;
    }

}
