package com.omegapoint.latetuna.proposal.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventConsumerSpring {

	private final ConferenceConsumer consumer;

	@Autowired
	public EventConsumerSpring(ConferenceConsumer consumer) {
		this.consumer = consumer;
    }

	@Scheduled(fixedDelay = 1000)
	public void consumeNewEvents() {
		consumer.receive();
	}
}
