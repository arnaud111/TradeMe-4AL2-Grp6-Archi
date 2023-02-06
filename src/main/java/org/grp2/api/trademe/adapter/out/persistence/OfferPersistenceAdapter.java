package org.grp2.api.trademe.adapter.out.persistence;

import org.grp2.api.trademe.adapter.out.entity.OfferEntity;
import org.grp2.api.trademe.adapter.out.repository.OfferEntityRepository;
import org.grp2.api.trademe.application.mapper.ConsultantEntityMapper;
import org.grp2.api.trademe.application.mapper.OfferEntityMapper;
import org.grp2.api.trademe.application.port.out.offer.CreateOfferPort;
import org.grp2.api.trademe.application.port.out.offer.FindAllOfferPort;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;

import java.util.List;
import java.util.UUID;

public class OfferPersistenceAdapter implements CreateOfferPort, FindAllOfferPort {

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
        OfferEntity offerEntity = OfferEntityMapper.domainOfferToOfferEntity(offer);
        offerEntityRepository.save(offerEntity);
    }

    @Override
    public List<Offer> findAll() {
        return OfferEntityMapper.offerEntitiesToDomainOffers(offerEntityRepository.findAll());
    }
}
