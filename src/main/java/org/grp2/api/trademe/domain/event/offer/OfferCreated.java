package org.grp2.api.trademe.domain.event.offer;

import org.grp2.api.trademe.domain.dto.offer.OfferId;
import org.grp2.kernel.Event;

public class OfferCreated implements Event {

    private final OfferId offerId;

    public OfferCreated(OfferId offerId) {
        this.offerId = offerId;
    }

    public OfferId getOfferId() {
        return offerId;
    }
}
