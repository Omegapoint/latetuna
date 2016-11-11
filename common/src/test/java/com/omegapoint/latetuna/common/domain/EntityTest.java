package com.omegapoint.latetuna.common.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class EntityTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldCreateAnEntityWithAValidIdentity() {
        Identity identity = new Identity();
        TestEntity entity = new TestEntity(identity);

        assertThat(entity.getIdentity()).isEqualTo(identity);
    }

    @Test
    public void shouldThrowWhenCreatedWithANullIdentity() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("identity can't be null");

        new TestEntity(null);
    }

    private static class TestEntity extends Entity {

        TestEntity(Identity identity) {
            super(identity);
        }
    }
}
