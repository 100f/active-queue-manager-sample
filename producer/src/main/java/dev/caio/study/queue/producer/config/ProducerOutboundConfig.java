package dev.caio.study.queue.producer.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;

@Configuration
public class ProducerOutboundConfig {

    @Autowired
    private RabbitTemplate producerTemplate;

    @Bean
    IntegrationFlow toOutboundQueue() {
        return IntegrationFlows
                .from("producer-channel")
                .transform(Transformers.toJson())
                .handle(Amqp.outboundAdapter(producerTemplate))
                .get();
    }
}
