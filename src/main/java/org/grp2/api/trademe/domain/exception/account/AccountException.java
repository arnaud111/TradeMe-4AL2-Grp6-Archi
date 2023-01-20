package org.grp2.api.trademe.domain.exception.account;


import org.grp2.api.trademe.domain.dto.account.AccountId;

public final class AccountException extends RuntimeException {

    private AccountException(String message) {
        super(message);
    }

    public static AccountException notFoundAccountId(AccountId accountId) {
        return new AccountException(String.format("%s not found.", accountId.value()));
    }
}
