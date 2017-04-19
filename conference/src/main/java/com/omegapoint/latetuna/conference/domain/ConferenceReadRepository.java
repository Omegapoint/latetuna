package com.omegapoint.latetuna.conference.domain;

import java.util.List;

public interface ConferenceReadRepository {
    List<Conference> list();

	Conference persist(Conference conference);
}
