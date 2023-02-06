package org.grp2.api.trademe.domain.dto.offer;

import java.util.Objects;
import java.util.UUID;

public class OfferId {

    private final UUID value;

    public OfferId(UUID value) {
        this.value = value;
    }

    public static OfferId of(UUID value) {
        return new OfferId(value);
    }

    public static OfferId of(String value) {
        return new OfferId(UUID.fromString(value));
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
        OfferId offerId = (OfferId) obj;
        return Objects.equals(this.value, offerId.value);
    }

    @Override
    public String toString() {
        return "OfferId {" +
                "value='" + this.value + '\'' +
                '}';
    }
}
