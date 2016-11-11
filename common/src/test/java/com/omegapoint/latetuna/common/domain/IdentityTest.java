package com.omegapoint.latetuna.common.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class IdentityTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldCreateAnIdentityWithoutArguments() {
        new Identity();
    }

    @Test
    public void shouldCreateAnIdentityFromSpecifiedUUID() {
        UUID uuid = UUID.randomUUID();
        Identity identity = new Identity(uuid);

        assertThat(identity.getUuid()).isEqualTo(uuid);
    }

    @Test
    public void shouldCreateAnIdentityFromAUUIDString() {
        UUID uuid = UUID.randomUUID();
        Identity identity = new Identity(uuid.toString());

        assertThat(identity.getUuid()).isEqualTo(uuid);
    }

    @Test
    public void shouldCreateTwoEqualIdentitiesFromTheSameUUID() {
        Identity identity1 = new Identity();
        Identity identity2 = new Identity(identity1.getUuid());

        assertThat(identity1).isEqualTo(identity2);
    }

    @Test
    public void shouldThrowWhenCreatedWithANullString() {
        thrown.expect(NullPointerException.class);

        new Identity((String) null);
    }

    @Test
    public void shouldThrowWhenCreatedWithANullUUID() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("uuid can't be null");

        new Identity((UUID) null);
    }
}
