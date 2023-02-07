package org.grp2.api.trademe.application.port.out.offer;

import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;

public interface LoadOfferPort {

    Offer load(OfferId offerId);
}
