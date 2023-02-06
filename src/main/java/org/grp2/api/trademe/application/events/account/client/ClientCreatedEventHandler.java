package org.grp2.api.trademe.application.events.account.client;

import org.grp2.api.trademe.application.port.out.notification.Notifications;
import org.grp2.kernel.EventHandler;

public class ClientCreatedEventHandler implements EventHandler<ClientCreatedApplicationEvent> {

    private final Notifications notifications;

    public ClientCreatedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(ClientCreatedApplicationEvent event) {
        notifications.notify(String.format("Notification of the account creation %s.", event.getAccountId()));
    }
}
