package org.grp2.api.trademe.domain.exception.offer;

import org.grp2.api.trademe.domain.dto.offer.OfferId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public final class OfferException extends RuntimeException {

    private OfferException(String message) {
        super(message);
    }

    public static OfferException notFoundOfferId(OfferId offerId) {
        return new OfferException(String.format("Offer: %s not found.", offerId.value()));
    }
}
