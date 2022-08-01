package dev.caio.study.queue.consumer.service.communication;

import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Component
public class ApplicationMessageHandler implements GenericHandler<Map<String, Serializable>> {

    @Override
    public Object handle(Map<String, Serializable> payload, MessageHeaders headers) {
        System.out.println(payload.get("MENSAGEM"));
        return null;
    }
}
