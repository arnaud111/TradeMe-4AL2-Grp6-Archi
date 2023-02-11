package org.grp2.api.trademe.application.services.offer;

import org.grp2.api.trademe.application.events.offer.OfferCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.offer.CreateOfferCommand;
import org.grp2.api.trademe.application.port.in.usecase.offer.CreateOfferUseCase;
import org.grp2.api.trademe.application.port.out.account.client.LoadClientPort;
import org.grp2.api.trademe.application.port.out.offer.CreateOfferPort;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.exception.account.client.ClientException;
import org.grp2.kernel.Event;
import org.grp2.kernel.EventDispatcher;

public class CreateOfferService implements CreateOfferUseCase {

    private final CreateOfferPort createOfferPort;
    private final LoadClientPort loadClientPort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public CreateOfferService(CreateOfferPort createOfferPort, LoadClientPort loadClientPort, EventDispatcher<? super Event> eventDispatcher) {
        this.createOfferPort = createOfferPort;
        this.loadClientPort = loadClientPort;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String handle(CreateOfferCommand command) throws ClientException {
        var offerId = createOfferPort.nextId();
        var offer = new Offer(offerId, command.creatorAccountId);
        if (loadClientPort.load(command.creatorAccountId) == null) throw ClientException.notFoundAccountId(command.creatorAccountId);
        offer.setTitle(command.title);
        offer.setDescription(command.description);
        createOfferPort.save(offer);
        eventDispatcher.dispatch(new OfferCreatedApplicationEvent(offerId));
        return offerId.value();
    }
}
