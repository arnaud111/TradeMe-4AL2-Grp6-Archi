package org.grp2.api.trademe.application.events;

import org.grp2.api.trademe.domain.UserId;
import org.grp2.kernel.Event;

public class ConsultantCreatedApplicationEvent implements Event {

    private final UserId userId;

    public ConsultantCreatedApplicationEvent(UserId userId) {
        this.userId = userId;
    }

    public UserId getAccountId() {
        return userId;
    }
}