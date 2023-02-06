package org.grp2.api.trademe.application.port.out.offer;

import org.grp2.api.trademe.domain.dto.offer.Offer;

import java.util.List;

public interface FindAllOfferPort {

    List<Offer> findAll();
}
