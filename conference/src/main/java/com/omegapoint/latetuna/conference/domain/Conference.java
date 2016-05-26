package com.omegapoint.latetuna.conference.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Conference {

    @JsonProperty
    private final UUID id;

    @JsonProperty
    private String name;

    public Conference(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }
}
