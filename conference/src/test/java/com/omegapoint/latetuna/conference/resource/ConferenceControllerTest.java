package com.omegapoint.latetuna.conference.resource;

import com.omegapoint.latetuna.conference.domain.Conference;
import com.omegapoint.latetuna.conference.domain.ConferenceReadRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConferenceControllerTest {


	private ConferenceController controller;
	private Conference conference;
	private List<Conference> conferences;
	private ConferenceProducer producer;
	private ConferenceReadRepository conferenceReadRepository;

	@Before
	public void setup() {
		conferenceReadRepository = mock(ConferenceReadRepository.class);
		producer = mock(ConferenceProducer.class);
		controller = new ConferenceController(conferenceReadRepository, producer);
	}

	@Ignore
	@Test
	public void createNewConference() throws Exception {
		whenAConferenceIsCreated();
		thenAnEventIsPublished();
	}

	@Ignore
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
		verify(producer, times(1)).send(JsonUtil.toJson(conference));
	}

	private void givenAConference() {
		conference = aConference();
		when(conferenceReadRepository.list()).thenReturn(Collections.singletonList(conference));
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