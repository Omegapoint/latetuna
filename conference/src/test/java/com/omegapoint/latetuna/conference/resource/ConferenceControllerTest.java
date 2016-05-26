package com.omegapoint.latetuna.conference.resource;

import com.omegapoint.latetuna.conference.domain.Conference;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ConferenceControllerTest {

    private ConferenceController controller;
    private Conference conference;
    private EventClientSpring eventClient;

    @Before
    public void setup() {
        eventClient = mock(EventClientSpring.class);
        controller = new ConferenceController(eventClient);
    }

    @Test
    public void createNewConference() throws Exception {
        whenAConferenceIsCreated();
        thenAnEventIsPublished();
    }

    private void whenAConferenceIsCreated() {
        conference = new Conference("UmeDev");
        controller.create(conference);
    }

    private void thenAnEventIsPublished() {
        verify(eventClient,times(1)).send("conference",conference);
    }


}