package org.grp2.api.trademe.domain.dto.account;

import org.grp2.api.trademe.domain.event.account.AccountCreated;
import org.grp2.kernel.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Account {

    private final AccountId accountId;
    private String email;
    private String password;
    private String name;
    private String lastName;

    private final List<Event> recordedEvents;

    public Account(AccountId accountId) {
        this.accountId = accountId;
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new AccountCreated(accountId));
    }

    public Account(AccountId accountId, String email, String password, String name, String lastName) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new AccountCreated(accountId));
    }

    public Account(UUID accountId, String email, String password, String name, String lastName) {
        this.accountId = AccountId.of(accountId);
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new AccountCreated(this.accountId));
    }

    public AccountId id() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Event> getRecordedEvents() {
        return Collections.unmodifiableList(recordedEvents);
    }
}
