package org.grp2.api.trademe.adapter.out;

import org.grp2.api.trademe.application.port.out.Notifications;

public final class LogNotifications implements Notifications {
    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
