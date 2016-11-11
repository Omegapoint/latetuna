package com.omegapoint.latetuna.common.domain;

import java.util.Objects;

public abstract class Entity {

    private final Identity identity;

    public Entity(Identity identity) {
        Objects.requireNonNull(identity, ()  -> "identity can't be null.");
        this.identity = identity;
    }

    public Identity getIdentity() {
        return identity;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        return identity.equals(((Entity) o).identity);

    }

    @Override
    public final int hashCode() {
        return identity.hashCode();
    }
}
