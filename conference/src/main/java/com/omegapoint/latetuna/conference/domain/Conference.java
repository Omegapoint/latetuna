package com.omegapoint.latetuna.conference.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Conference {

    @JsonProperty
    private final UUID id;

    @JsonProperty
    private final String city;

    @JsonProperty
    private String name;

    @JsonCreator
    public Conference(@JsonProperty("name") String name, @JsonProperty("name") String city) {
        this.city = city;
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String city() {
        return this.city;
    }
}
