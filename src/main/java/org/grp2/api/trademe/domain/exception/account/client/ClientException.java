package org.grp2.api.trademe.domain.exception.account.client;

import org.grp2.api.trademe.domain.dto.account.AccountId;

public final class ClientException extends RuntimeException {

    private ClientException(String message) {
        super(message);
    }

    public static ClientException notFoundAccountId(AccountId accountId) {
        return new ClientException(String.format("Client: %s not found.", accountId.value()));
    }
}
