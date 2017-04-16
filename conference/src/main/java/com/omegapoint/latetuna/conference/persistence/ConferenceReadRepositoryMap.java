package com.omegapoint.latetuna.conference.persistence;

import com.omegapoint.latetuna.conference.domain.Conference;
import com.omegapoint.latetuna.conference.domain.ConferenceReadRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ConferenceReadRepositoryMap implements ConferenceReadRepository {

	List<Conference> conferences = new ArrayList<>();

    @Override
    public List<Conference> list() {
        return Collections.unmodifiableList(this.conferences);
    }

	@Override
	public Conference persist(Conference conference) {
    	conferences.add(conference);
		return conference;
	}
}
