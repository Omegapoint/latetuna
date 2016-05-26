package com.omegapoint.latetuna.conference.resource;

import com.omegapoint.latetuna.conference.domain.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ConferenceController {

    private EventClientSpring eventClient;

    @Autowired
    public ConferenceController(EventClientSpring eventClient) {
        this.eventClient = eventClient;
    }

    @RequestMapping(value = "/", method = GET)
    public String list() {
        //TODO: This is a test event, move it to the "create" method and adapt it
        eventClient.send("conference", new Conference("I am a conference!!"));
        return "List conferences";
    }

    @RequestMapping(value = "/", method = POST)
    public Conference create(@RequestBody Conference conference) {
        eventClient.send("conference",conference);
        return conference;
    }
}
