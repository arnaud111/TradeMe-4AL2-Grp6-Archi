package org.grp2.api.trademe.adapter.out.persistence;

import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.grp2.api.trademe.adapter.out.entity.OfferEntity;
import org.grp2.api.trademe.adapter.out.repository.OfferEntityRepository;
import org.grp2.api.trademe.application.mapper.ConsultantMapper;
import org.grp2.api.trademe.application.mapper.OfferMapper;
import org.grp2.api.trademe.application.port.out.offer.CreateOfferPort;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;

import java.util.UUID;

public class OfferPersistenceAdapter implements CreateOfferPort {

    private final OfferEntityRepository offerEntityRepository;

    public OfferPersistenceAdapter(OfferEntityRepository offerEntityRepository) {
        this.offerEntityRepository = offerEntityRepository;
    }

    @Override
    public OfferId nextId() {
        return OfferId.of(UUID.randomUUID());
    }

    @Override
    public void save(Offer offer) {
        OfferEntity offerEntity = OfferMapper.domainOfferToOfferEntity(offer);
        offerEntityRepository.save(offerEntity);
    }
}
