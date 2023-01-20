package org.grp2.api.trademe.domain.event.account;

import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.kernel.Event;

public class AccountCreated implements Event {

    private final AccountId accountId;

    public AccountCreated(AccountId accountId) {
        this.accountId = accountId;
    }

    public AccountId getAccountId() {
        return accountId;
    }
}
