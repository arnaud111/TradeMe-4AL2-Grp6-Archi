package org.grp2.api.trademe.domain.exception.account.consultant;

import org.grp2.api.trademe.domain.dto.account.AccountId;

public class ConsultantException extends RuntimeException {

    private ConsultantException(String message) {
        super(message);
    }

    public static ConsultantException notFoundAccountId(AccountId accountId) {
        return new ConsultantException(String.format("Consultant: %s not found.", accountId.value()));
    }
}
