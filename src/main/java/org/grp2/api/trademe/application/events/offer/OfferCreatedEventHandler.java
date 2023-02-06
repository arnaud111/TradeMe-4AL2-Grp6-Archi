package org.grp2.api.trademe.application.events.offer;

import org.grp2.api.trademe.application.events.account.consultant.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.out.notification.Notifications;
import org.grp2.kernel.EventHandler;

public class OfferCreatedEventHandler implements EventHandler<OfferCreatedApplicationEvent> {

    private final Notifications notifications;

    public OfferCreatedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(OfferCreatedApplicationEvent event) {
        notifications.notify(String.format("Notification of the account creation %s.", event.getOfferId()));
    }
}
