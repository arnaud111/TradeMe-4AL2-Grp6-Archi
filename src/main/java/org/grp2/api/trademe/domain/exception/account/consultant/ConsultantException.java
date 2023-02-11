package org.grp2.api.trademe.domain.exception.account.consultant;

import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ConsultantException extends RuntimeException {

    private ConsultantException(String message) {
        super(message);
    }

    public static ConsultantException notFoundAccountId(AccountId accountId) {
        return new ConsultantException(String.format("Consultant: %s not found.", accountId.value()));
    }
}
