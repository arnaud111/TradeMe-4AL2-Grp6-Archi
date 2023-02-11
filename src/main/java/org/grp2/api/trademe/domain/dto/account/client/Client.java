package org.grp2.api.trademe.domain.dto.account.client;

import org.grp2.api.trademe.domain.dto.account.Account;
import org.grp2.api.trademe.domain.dto.account.AccountId;

import java.util.UUID;

public class Client extends Account {

    public Client(AccountId accountId) {
        super(accountId);
    }

    public Client(AccountId accountId, String email, String password, String name, String lastName) {
        super(accountId, email, password, name, lastName);
    }

    public Client(UUID accountId, String email, String password, String name, String lastName) {
        super(accountId, email, password, name, lastName);
    }
}
