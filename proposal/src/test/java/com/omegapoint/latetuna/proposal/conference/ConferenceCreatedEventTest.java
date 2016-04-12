package com.omegapoint.latetuna.proposal.conference;


import au.com.dius.pact.consumer.MessagePactBuilder;
import au.com.dius.pact.consumer.MessagePactProviderRule;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.model.v3.messaging.MessagePact;
import com.omegapoint.latetuna.proposal.event.ConferenceEvent;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ConferenceCreatedEventTest {

    @Rule
    public MessagePactProviderRule mockProvider = new MessagePactProviderRule(this);

    @Pact(provider = "conference", consumer = "proposal")
    public MessagePact createPact(MessagePactBuilder builder) {
        PactDslJsonBody body = new PactDslJsonBody();
        body.stringValue("name", "QCon");
        body.stringValue("city", "London");

        Map<String, String> metadata = new HashMap<>();
        metadata.put("contentType", "application/json");

        return builder.given("CreatedConference")
                .expectsToReceive("a test message")
                .withMetadata(metadata)
                .withContent(body)
                .toPact();
    }

    @Test
    @PactVerification({"conference", "CreatedConference"})
    public void reciveAConferenceEvent() throws Exception {
        String json = new String(currentMessage);
        assertThat(json).isNotNull();
        ConferenceEvent conferenceEvent = ConferenceEvent.fromJson(json);
        assertThat(conferenceEvent.name()).isEqualTo("QCon");
        assertThat(conferenceEvent.city()).isEqualTo("London");
    }

    public void setMessage(byte[] messageContents) {
        currentMessage = messageContents;
    }

    private byte[] currentMessage;

}
