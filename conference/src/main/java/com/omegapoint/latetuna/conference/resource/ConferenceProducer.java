package com.omegapoint.latetuna.conference.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class ConferenceProducer implements Producer {
	private MessageChannel toKafka;

	@Autowired
	public ConferenceProducer(@Qualifier("toKafka") MessageChannel toKafka) {
		this.toKafka = toKafka;
	}

	public void send(String message) {
		Message<?> content = new GenericMessage<String>(message);
		toKafka.send(content);
	}

}
