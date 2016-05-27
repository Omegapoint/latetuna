package com.omegapoint.latetuna.conference.resource;

import com.omegapoint.latetuna.eventbus.client.EventClient;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EventClientSpring {

    private EventClient eventClient = new EventClient();

    public void send(String topic, Object value) {
        eventClient.send(topic, UUID.randomUUID().toString(),JsonUtil.toJson(value));
    }
}
