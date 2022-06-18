package dev.caio.study.queue.consumer.consumers;

import dev.caio.study.queue.consumer.dto.ApplicationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConsumer {

    @RabbitListener(queues = "${spring.rabbitmq.queue-name}")
    public void onMessageReceived(@Payload ApplicationMessage message) {
        System.out.println(String.format("Arquivo rotulado com %s lido com sucesso! Mensagem: \"%s\"", message.getRotulo(), message.getMensagem()));
    }
}
