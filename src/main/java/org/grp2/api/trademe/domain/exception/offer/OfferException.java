package org.grp2.api.trademe.domain.exception.offer;

import org.grp2.api.trademe.domain.dto.offer.OfferId;

public class OfferException extends RuntimeException {

    private OfferException(String message) {
        super(message);
    }

    public static OfferException notFoundOfferId(OfferId offerId) {
        return new OfferException(String.format("Offer: %s not found.", offerId.value()));
    }
}
