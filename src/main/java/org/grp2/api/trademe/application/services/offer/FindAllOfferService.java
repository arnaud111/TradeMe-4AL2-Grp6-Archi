package org.grp2.api.trademe.application.services.offer;

import org.grp2.api.trademe.application.port.in.command.offer.FindAllOfferCommand;
import org.grp2.api.trademe.application.port.in.usecase.offer.FindAllOfferUseCase;
import org.grp2.api.trademe.application.port.out.offer.FindAllOfferPort;
import org.grp2.api.trademe.domain.dto.offer.Offer;

import java.util.List;

public class FindAllOfferService implements FindAllOfferUseCase {

    private final FindAllOfferPort findAllOfferPort;

    public FindAllOfferService(FindAllOfferPort findAllOfferPort) {
        this.findAllOfferPort = findAllOfferPort;
    }

    @Override
    public List<Offer> handle(FindAllOfferCommand command) {
        return this.findAllOfferPort.findAll();
    }
}
