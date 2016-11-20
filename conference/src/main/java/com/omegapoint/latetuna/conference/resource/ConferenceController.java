package com.omegapoint.latetuna.conference.resource;

import com.omegapoint.latetuna.conference.domain.Conference;
import com.omegapoint.latetuna.conference.domain.ConferenceReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ConferenceController {

    private ConferenceReadRepository conferenceReadRepository;
    private EventClientSpring eventClient;

    @Autowired
    public ConferenceController(ConferenceReadRepository conferenceReadRepository, EventClientSpring eventClient) {
        this.conferenceReadRepository = conferenceReadRepository;
        this.eventClient = eventClient;
    }

    @RequestMapping(value = "/", method = GET)
    public List<Conference> list() {
        return conferenceReadRepository.list();
    }

    @RequestMapping(value = "/", method = POST)
    public String create(@RequestBody Conference conference) {
        eventClient.send("conference", conference);
        return conference.id().toString();
    }
}
