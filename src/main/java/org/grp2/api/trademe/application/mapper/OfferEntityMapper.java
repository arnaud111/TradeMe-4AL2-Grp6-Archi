package org.grp2.api.trademe.application.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.grp2.api.trademe.adapter.out.entity.EventEntity;
import org.grp2.api.trademe.adapter.out.entity.OfferEntity;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferEntityMapper {

    public static OfferEntity domainOfferToOfferEntity(Offer offer) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();

        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(offer.getOfferId().value());
        offerEntity.setCreatorAccountId(offer.getCreatorAccountId().value());
        offerEntity.setDescription(offer.getDescription());
        offerEntity.setTitle(offer.getTitle());
        offerEntity.setRecordedEvents(offer.getRecordedEvents().stream().map(event ->
                new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));

        return offerEntity;
    }

    public static Offer offerEntityToDomainOffer(OfferEntity offerEntity) {

        Offer offer = new Offer(OfferId.of(offerEntity.getId()), AccountId.of(offerEntity.getCreatorAccountId()));
        offer.setDescription(offerEntity.getDescription());
        offer.setTitle(offerEntity.getTitle());

        return offer;
    }

    public static List<Offer> offerEntitiesToDomainOffers(List<OfferEntity> offerEntities) {
        List<Offer> offers = new ArrayList<>();
        for (OfferEntity offerEntity : offerEntities) {
            offers.add(OfferEntityMapper.offerEntityToDomainOffer(offerEntity));
        }
        return offers;
    }
}
