package org.grp2.api.trademe.application.events.account.client;

import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.kernel.Event;

public class ClientCreatedApplicationEvent implements Event {

    private final AccountId accountId;

    public ClientCreatedApplicationEvent(AccountId accountId) {
        this.accountId = accountId;
    }

    public AccountId getAccountId() {
        return accountId;
    }
}
