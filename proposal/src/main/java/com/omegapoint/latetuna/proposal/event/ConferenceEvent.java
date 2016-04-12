package com.omegapoint.latetuna.proposal.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConferenceEvent {
    private final String name;
    private final String city;

    @JsonCreator
    public ConferenceEvent(@JsonProperty("name") String name, @JsonProperty("city") String city) {
        this.name = name;
        this.city = city;
    }

    public String name() {
        return name;
    }

    public String city() {
        return city;
    }

    public static ConferenceEvent fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(json, ConferenceEvent.class);
    }
}
