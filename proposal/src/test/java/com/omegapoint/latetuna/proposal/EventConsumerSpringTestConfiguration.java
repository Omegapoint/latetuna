package com.omegapoint.latetuna.proposal;

import com.omegapoint.latetuna.proposal.event.EventConsumerSpring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class EventConsumerSpringTestConfiguration {

    @Bean
    @Primary
    public EventConsumerSpring eventConsumerSpring() {
        return mock(EventConsumerSpring.class);
    }
}
