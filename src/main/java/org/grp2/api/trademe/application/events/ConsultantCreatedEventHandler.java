package org.grp2.api.trademe.application.events;

import org.grp2.api.trademe.application.port.out.notification.Notifications;
import org.grp2.kernel.EventHandler;

public final class ConsultantCreatedEventHandler implements EventHandler<ConsultantCreatedApplicationEvent> {

    private final Notifications notifications;

    public ConsultantCreatedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(ConsultantCreatedApplicationEvent event) {
        notifications.notify(String.format("Notification of the account creation %s.", event.getAccountId()));
    }
}
