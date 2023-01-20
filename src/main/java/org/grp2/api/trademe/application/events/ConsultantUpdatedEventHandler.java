package org.grp2.api.trademe.application.events;

import org.grp2.api.trademe.application.port.out.notification.Notifications;
import org.grp2.kernel.EventHandler;

public class ConsultantUpdatedEventHandler implements EventHandler<ConsultantUpdatedApplicationEvent> {

    private final Notifications notifications;

    public ConsultantUpdatedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(ConsultantUpdatedApplicationEvent event) {
        notifications.notify(String.format("Notification of the account update %s.", event.getAccountId()));
    }
}
