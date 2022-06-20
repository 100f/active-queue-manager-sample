package dev.caio.study.queue.producer.controller;

import dev.caio.study.queue.consumer.dto.ApplicationMessage;
import dev.caio.study.queue.producer.dto.MensagemDTO;
import dev.caio.study.queue.producer.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/message")
public class CentralController {

    @Autowired
    private CommunicationService communicationService;

    @PostMapping(path = "/send")
    public void sendMessage(@RequestParam(required = true) String rotulo, @RequestBody MensagemDTO mensagemDTO) {
        final ApplicationMessage message = new ApplicationMessage();
        message.setMensagem(mensagemDTO.getMensagem());
        message.setRotulo(rotulo);
        communicationService.sendMessage(message);
    }
}
