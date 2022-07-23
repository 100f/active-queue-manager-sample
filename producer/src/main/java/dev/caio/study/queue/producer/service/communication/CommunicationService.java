package dev.caio.study.queue.producer.service.communication;

import com.dev.caio.study.queue.communicationmanagerlib.domain.ApplicationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunicationService {

    @Autowired
    private CommunicationGateway communicationGateway;

    public void sendMessage(ApplicationMessage message) {
        try {
            communicationGateway.notificar(message);
        }
        catch (Exception exception) {
            System.out.println("Erro ao enviar a mensagem: " + exception.getLocalizedMessage());
        }
    }
}
