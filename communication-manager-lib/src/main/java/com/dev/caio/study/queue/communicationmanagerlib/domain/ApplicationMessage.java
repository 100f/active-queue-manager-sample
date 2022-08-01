package com.dev.caio.study.queue.communicationmanagerlib.domain;

import lombok.Getter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ApplicationMessage extends GenericMessage<Map<String, Serializable>> {

    public ApplicationMessage(String messageType, String ownerApp, String rotulo, Map<String, Serializable> payload) {
        super(payload, buildHeaders(messageType, ownerApp, rotulo));
    }

    private static Map<String, Object> buildHeaders(String messageType, String ownerApp, String rotulo) {
        Map<String, Object> builtHeaders = new HashMap<>();
        builtHeaders.put("MESSAGE_TYPE", messageType);
        builtHeaders.put("ROTULO", rotulo);
        builtHeaders.put("OWNER_APP", ownerApp);
        return builtHeaders;
    }
}
