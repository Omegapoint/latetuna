package com.omegapoint.latetuna.conference;

import com.omegapoint.latetuna.conference.resource.EventClientSpring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class EventClientSpringTestConfiguration {

    @Bean
    @Primary
    public EventClientSpring eventClientSpring() {
        return mock(EventClientSpring.class);
    }
}
