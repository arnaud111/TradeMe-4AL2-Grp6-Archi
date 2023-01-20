package org.grp2.api.trademe.domain.dto.account.client;

import org.grp2.api.trademe.domain.dto.account.Account;
import org.grp2.api.trademe.domain.dto.account.AccountId;

public class Client extends Account {

    public Client(AccountId accountId) {
        super(accountId);
    }
}
