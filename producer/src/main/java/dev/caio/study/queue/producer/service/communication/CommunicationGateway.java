package dev.caio.study.queue.producer.service.communication;

import com.dev.caio.study.queue.communicationmanagerlib.domain.ApplicationMessage;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface CommunicationGateway {
    @Gateway(requestChannel = "producer-channel")
    void notificar(ApplicationMessage mensagem);
}
