package org.grp2.api.trademe.adapter.in.mapper;

import org.grp2.api.trademe.adapter.in.offer.response.OfferResponse;
import org.grp2.api.trademe.domain.dto.offer.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class OfferApiMapper {

    public static OfferResponse offerToOfferResponse(Offer offer) {
        return new OfferResponse(
                offer.getOfferId().value(),
                offer.getCreatorAccountId().value(),
                offer.getTitle(),
                offer.getDescription()
        );
    }

    public static List<OfferResponse> offersToOfferResponses(List<Offer> offers) {
        return offers.stream()
                .map(OfferApiMapper::offerToOfferResponse)
                .collect(Collectors.toList());
    }
}
