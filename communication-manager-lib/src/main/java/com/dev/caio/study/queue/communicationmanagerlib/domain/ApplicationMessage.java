package com.dev.caio.study.queue.communicationmanagerlib.domain;

import lombok.Getter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ApplicationMessage implements Message<Map<String, Serializable>> {
    private Map<String, Serializable> payload;
    private Map<String, Object> headers;

    public ApplicationMessage(String messageType, String ownerApp, String rotulo, Map<String, Serializable> payload) {
        this.payload = payload;
        this.headers = buildHeaders(messageType, ownerApp, rotulo);
    }

    @Override
    public Map<String, Serializable> getPayload() {
        return payload;
    }

    public Boolean fodase() { return true; }

    @Override
    public MessageHeaders getHeaders() {
       return new MessageHeaders(this.headers);
    }

    private Map<String, Object> buildHeaders(String messageType, String ownerApp, String rotulo) {
        Map<String, Object> builtHeaders = new HashMap<>();
        builtHeaders.put("MESSAGE_TYPE", messageType);
        builtHeaders.put("ROTULO", rotulo);
        builtHeaders.put("OWNER_APP", ownerApp);
        return builtHeaders;
    }
}
