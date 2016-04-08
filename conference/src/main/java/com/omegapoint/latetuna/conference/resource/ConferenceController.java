package com.omegapoint.latetuna.conference.resource;

import com.omegapoint.latetuna.EventClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ConferenceController {

    @Autowired
    private EventClient eventClient;

    @RequestMapping(value = "/", method = GET)
    public String list() {
        return "List conferences";
    }

    @RequestMapping(value = "/", method = POST)
    public String create(@RequestParam(value="name") String name) {
        return "Create conferences " + name;
    }
}
