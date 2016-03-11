package com.omegapoint.latetuna.proposal.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/")
    public String hello() {
        return "Hello " + applicationName + "!";
    }
}
