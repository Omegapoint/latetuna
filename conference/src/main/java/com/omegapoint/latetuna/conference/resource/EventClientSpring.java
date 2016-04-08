package com.omegapoint.latetuna.conference.resource;

import com.omegapoint.latetuna.EventClient;
import org.springframework.stereotype.Component;

@Component
public class EventClientSpring {

    private EventClient eventClient = new EventClient();

    public void send(String topic, String key, String value) {
        eventClient.send(topic,key,value);
    }
}
