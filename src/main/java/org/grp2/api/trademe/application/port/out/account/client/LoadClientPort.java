package org.grp2.api.trademe.application.port.out.account.client;

import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;

public interface LoadClientPort {

    Client load(AccountId accountId);
}
