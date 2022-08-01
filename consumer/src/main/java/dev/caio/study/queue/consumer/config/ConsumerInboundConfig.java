package dev.caio.study.queue.consumer.config;

import com.dev.caio.study.queue.communicationmanagerlib.domain.ApplicationMessage;
import dev.caio.study.queue.consumer.service.communication.ApplicationMessageHandler;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;

@Configuration
public class ConsumerInboundConfig {

    @Autowired
    private SimpleMessageListenerContainer listenerContainer;

    @Autowired
    ApplicationMessageHandler handler;

    @Bean
    IntegrationFlow inboundMessageReceivingFlow() {
        return IntegrationFlows.from(Amqp.inboundAdapter(listenerContainer))
                .transform(Transformers.fromJson(ApplicationMessage.class))
                .handle(handler)
                .get();
    }
}
