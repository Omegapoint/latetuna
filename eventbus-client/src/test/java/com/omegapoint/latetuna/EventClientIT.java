package com.omegapoint.latetuna;

import org.junit.Test;

public class EventClientIT {

    @Test
    public void shouldSendMessage() {
        new EventClient().send();
    }
}
