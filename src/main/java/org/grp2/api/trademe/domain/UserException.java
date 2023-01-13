package org.grp2.api.trademe.domain;


public final class UserException extends RuntimeException {

    private UserException(String message) {
        super(message);
    }

    public static UserException notFoundUserId(UserId userId) {
        return new UserException(String.format("%s not found.", userId.value()));
    }
}
