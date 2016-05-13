package com.omegapoint.latetuna.proposal.event;

import com.omegapoint.latetuna.eventbus.client.EventConsumer;
import org.springframework.stereotype.Component;

@Component
public class EventConsumerSpring {

    public EventConsumerSpring() {
        new Thread(() -> {
            EventConsumer eventConsumer = new EventConsumer();
            eventConsumer.listen("conference");
        }).run();
    }
}
