package org.grp2.api.trademe.domain.dto.user.client;

import org.grp2.api.trademe.domain.dto.user.User;
import org.grp2.api.trademe.domain.dto.user.UserId;

public class Client extends User {

    public Client(UserId userId) {
        super(userId);
    }
}
