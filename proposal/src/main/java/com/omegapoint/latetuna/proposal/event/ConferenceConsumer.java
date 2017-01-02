package com.omegapoint.latetuna.proposal.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Component;

@Component
public class ConferenceConsumer implements Consumer{

	private PollableChannel pollableChannel;

	@Autowired
	public ConferenceConsumer(@Qualifier("fromKafka") PollableChannel pollableChannel) {
		this.pollableChannel = pollableChannel;
	}

	@Override
	public void receive() {
		Message<?> message = pollableChannel.receive(100);
		while (message != null) {
			System.out.println(message);
			message = pollableChannel.receive(100);
		}
	}
}
