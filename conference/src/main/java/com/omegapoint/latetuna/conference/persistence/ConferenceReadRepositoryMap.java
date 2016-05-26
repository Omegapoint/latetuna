package com.omegapoint.latetuna.conference.persistence;

import com.omegapoint.latetuna.conference.domain.Conference;
import com.omegapoint.latetuna.conference.domain.ConferenceReadRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ConferenceReadRepositoryMap implements ConferenceReadRepository {

    @Override
    public List<Conference> list() {
        //TODO: Read from actual storage
        return Collections.emptyList();
    }
}
