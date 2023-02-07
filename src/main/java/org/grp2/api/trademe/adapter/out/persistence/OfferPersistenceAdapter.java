package org.grp2.api.trademe.adapter.out.persistence;

import org.grp2.api.trademe.adapter.out.entity.OfferEntity;
import org.grp2.api.trademe.adapter.out.repository.OfferEntityRepository;
import org.grp2.api.trademe.adapter.out.mapper.OfferEntityMapper;
import org.grp2.api.trademe.application.port.out.offer.CreateOfferPort;
import org.grp2.api.trademe.application.port.out.offer.FindAllOfferPort;
import org.grp2.api.trademe.application.port.out.offer.LoadOfferPort;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OfferPersistenceAdapter implements CreateOfferPort, FindAllOfferPort, LoadOfferPort {

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

    @Override
    public Offer load(OfferId offerId) {
        Optional<OfferEntity> offerEntity = offerEntityRepository.findById(offerId.value());
        if (offerEntity.isEmpty()) return null;
        return OfferEntityMapper.offerEntityToDomainOffer(offerEntity.get());
    }
}
