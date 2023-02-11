package org.grp2.api.trademe.domain.exception.account;


import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public final class AccountException extends RuntimeException {

    private AccountException(String message) {
        super(message);
    }

    public static AccountException notFoundAccountId(AccountId accountId) {
        return new AccountException(String.format("Account: %s not found.", accountId.value()));
    }
}
