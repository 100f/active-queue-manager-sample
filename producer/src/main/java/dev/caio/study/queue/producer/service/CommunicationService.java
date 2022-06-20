package dev.caio.study.queue.producer.service;

import dev.caio.study.queue.consumer.dto.ApplicationMessage;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunicationService {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    Binding binding;

    public void sendMessage(ApplicationMessage message) {
        try {
            template.convertAndSend(binding.getExchange(), binding.getRoutingKey(), message);
        }
        catch (Exception exception) {
            System.out.println("Erro ao enviar a mensagem: " + exception.getLocalizedMessage());
        }
    }
}
