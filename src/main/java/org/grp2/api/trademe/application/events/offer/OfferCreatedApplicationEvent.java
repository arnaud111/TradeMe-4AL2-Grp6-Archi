package org.grp2.api.trademe.application.events.offer;

import org.grp2.api.trademe.domain.dto.offer.OfferId;
import org.grp2.kernel.Event;

public class OfferCreatedApplicationEvent implements Event {

    private final OfferId offerId;

    public OfferCreatedApplicationEvent(OfferId offerId) {
        this.offerId = offerId;
    }

    public OfferId getOfferId() {
        return offerId;
    }
}
