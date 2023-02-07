package org.grp2.api.trademe.adapter.in.mapper;

import org.grp2.api.trademe.adapter.in.controller.offer.response.OfferResponse;
import org.grp2.api.trademe.domain.dto.offer.Offer;

import java.util.List;
import java.util.stream.Collectors;

public class OfferApiMapper {

    public static OfferResponse offerToOfferResponse(Offer offer) {

        if (offer == null) return null;

        return new OfferResponse(
                offer.getOfferId().value(),
                offer.getCreatorAccountId().value(),
                offer.getTitle(),
                offer.getDescription()
        );
    }

    public static List<OfferResponse> offersToOfferResponses(List<Offer> offers) {

        if (offers == null) return null;

        return offers.stream()
                .map(OfferApiMapper::offerToOfferResponse)
                .collect(Collectors.toList());
    }
}
