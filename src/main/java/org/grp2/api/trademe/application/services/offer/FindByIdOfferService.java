package org.grp2.api.trademe.application.services.offer;

import org.grp2.api.trademe.application.port.in.command.offer.FindByIdOfferCommand;
import org.grp2.api.trademe.application.port.in.usecase.offer.FindByIdOfferUseCase;
import org.grp2.api.trademe.application.port.out.offer.LoadOfferPort;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;

public class FindByIdOfferService implements FindByIdOfferUseCase {

    private final LoadOfferPort loadOfferPort;

    public FindByIdOfferService(LoadOfferPort loadOfferPort) {
        this.loadOfferPort = loadOfferPort;
    }

    @Override
    public Offer handle(FindByIdOfferCommand command) {
        return this.loadOfferPort.load(OfferId.of(command.id));
    }
}