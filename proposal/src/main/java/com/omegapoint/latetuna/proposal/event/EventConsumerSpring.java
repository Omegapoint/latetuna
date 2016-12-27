package com.omegapoint.latetuna.proposal.event;

import com.omegapoint.latetuna.eventbus.client.EventConsumer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventConsumerSpring {

	private final EventConsumer eventConsumer;

	public EventConsumerSpring() {
		eventConsumer = new EventConsumer("test");
    }

	@Scheduled(fixedDelay = 1000)
	public void consumeNewEvents() {
		eventConsumer.consumeNewEvents();
	}
}
