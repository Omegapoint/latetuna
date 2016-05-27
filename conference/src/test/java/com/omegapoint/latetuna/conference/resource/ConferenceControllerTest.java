package com.omegapoint.latetuna.conference.resource;

import com.omegapoint.latetuna.conference.domain.Conference;
import com.omegapoint.latetuna.conference.domain.ConferenceReadRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ConferenceControllerTest {

    private ConferenceController controller;
    private Conference conference;
    private List<Conference> conferences;
    private EventClientSpring eventClient;
    private ConferenceReadRepository conferenceReadRepository;

    @Before
    public void setup() {
        conferenceReadRepository = mock(ConferenceReadRepository.class);
        eventClient = mock(EventClientSpring.class);
        controller = new ConferenceController(conferenceReadRepository,eventClient);
    }

    @Test
    public void createNewConference() throws Exception {
        whenAConferenceIsCreated();
        thenAnEventIsPublished();
    }

    @Test
    public void listAllConferences() throws Exception {
        givenAConference();
        whenConferencesAreListed();
        thenTheConferenceIsReturned();
    }


    private void whenAConferenceIsCreated() {
        conference = aConference();
        controller.create(conference);
    }

    private void thenAnEventIsPublished() {
        verify(eventClient,times(1)).send("conference",conference);
    }

    private void givenAConference() {
        conference = aConference();
        when(conferenceReadRepository.list()).thenReturn(Arrays.asList(conference));
    }

    private void whenConferencesAreListed() {
        conferences = controller.list();
    }

    private void thenTheConferenceIsReturned() {
        assertThat(conferences).containsOnly(conference);
    }

    private Conference aConference() {
        return new Conference("UmeDev");
    }
}