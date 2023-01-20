package org.grp2.api.trademe.domain.dto.account;

import java.util.Objects;
import java.util.UUID;

public final class AccountId {

    private final UUID value;

    public AccountId(UUID value) {
        this.value = value;
    }

    public static AccountId of(UUID value) {
        return new AccountId(value);
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
        AccountId accountId = (AccountId) obj;
        return Objects.equals(this.value, accountId.value);
    }

    @Override
    public String toString() {
        return "AccountId {" +
                "value='" + this.value + '\'' +
                '}';
    }
}
