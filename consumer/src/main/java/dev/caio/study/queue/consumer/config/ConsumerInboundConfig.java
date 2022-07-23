package dev.caio.study.queue.consumer.config;

import com.dev.caio.study.queue.communicationmanagerlib.domain.ApplicationMessage;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;

public class ConsumerInboundConfig {

    @Autowired
    private SimpleMessageListenerContainer listenerContainer;

    @Bean
    IntegrationFlow inboundMessageReceivingFlow() {
        return IntegrationFlows.from(Amqp.inboundAdapter(listenerContainer))
                .transform(Transformers.fromJson(ApplicationMessage.class))
                .handle(System.out::println)
                .get();
    }
}
