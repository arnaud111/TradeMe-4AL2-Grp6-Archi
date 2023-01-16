package org.grp2.api.trademe.domain.event.user;

import org.grp2.api.trademe.domain.dto.user.UserId;
import org.grp2.kernel.Event;

public class UserCreated implements Event {

    private final UserId userId;

    public UserCreated(UserId userId) {
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }
}
