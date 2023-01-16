package org.grp2.api.trademe.domain.dto.user;

import java.util.Objects;
import java.util.UUID;

public final class UserId {

    private final UUID value;

    public UserId(UUID value) {
        this.value = value;
    }

    public static UserId of(UUID value) {
        return new UserId(value);
    }

    public String value() {
        return this.value.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserId userId = (UserId) obj;
        return Objects.equals(this.value, userId.value);
    }

    @Override
    public String toString() {
        return "UserId {" +
                "value='" + this.value + '\'' +
                '}';
    }
}
