package dev.caio.study.queue.producer.controller;

import com.dev.caio.study.queue.communicationmanagerlib.domain.ApplicationMessage;
import dev.caio.study.queue.producer.dto.MensagemDTO;
import dev.caio.study.queue.producer.service.communication.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/message")
public class ProducerController {

    @Autowired
    private CommunicationService communicationService;

    @PostMapping(path = "/notificar")
    public void sendMessage(@RequestParam String rotulo, @RequestBody MensagemDTO mensagemDTO) {
        final Map<String, Serializable> payloadTeste = new HashMap<>();
        payloadTeste.put("FOO", "BAR");
        final ApplicationMessage message = new ApplicationMessage("", rotulo, "producer-name", new HashMap<>());
        communicationService.sendMessage(message);
    }
}
