package com.omegapoint.latetuna.common.domain;

import java.util.Objects;
import java.util.UUID;

public final class Identity {

    private final UUID uuid;

    public Identity() {
        this(UUID.randomUUID());
    }

    public Identity(String uuid) {
        this(UUID.fromString(uuid));
    }

    public Identity(UUID uuid) {
        Objects.requireNonNull(uuid, () -> "uuid can't be null");
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return uuid.equals(((Identity) o).uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid.toString();
    }
}
