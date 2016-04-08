package com.omegapoint.latetuna.conference.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ConferenceController {

    @Autowired
    private EventClientSpring eventClient;

    @RequestMapping(value = "/", method = GET)
    public String list() {
        //TODO: This is a test event, move it to the "create" method and adapt it
        eventClient.send("conference", UUID.randomUUID().toString(),"I am a conference!!");
        return "List conferences";
    }

    @RequestMapping(value = "/", method = POST)
    public String create(@RequestParam(value="name") String name) {
        return "Create conferences " + name;
    }
}
