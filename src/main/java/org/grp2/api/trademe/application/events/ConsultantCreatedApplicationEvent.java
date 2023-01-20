package org.grp2.api.trademe.application.events;

import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.kernel.Event;

public class ConsultantCreatedApplicationEvent implements Event {

    private final AccountId accountId;

    public ConsultantCreatedApplicationEvent(AccountId accountId) {
        this.accountId = accountId;
    }

    public AccountId getAccountId() {
        return accountId;
    }
}