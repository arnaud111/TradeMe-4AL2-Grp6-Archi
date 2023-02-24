package application.services.offer;

import org.grp2.api.trademe.application.events.offer.OfferCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.offer.CreateOfferCommand;
import org.grp2.api.trademe.application.port.out.account.client.LoadClientPort;
import org.grp2.api.trademe.application.port.out.offer.CreateOfferPort;
import org.grp2.api.trademe.application.services.offer.CreateOfferService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;
import org.grp2.kernel.EventDispatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateOfferServiceTest {

    @Mock
    private CreateOfferPort createOfferPort;
    @Mock
    private LoadClientPort loadClientPort;
    @Mock
    private EventDispatcher eventDispatcher;

    @InjectMocks
    private CreateOfferService createOfferService;

    @Test
    public void handle_withValidCommand_shouldSaveOfferAndDispatchOfferCreatedEvent() {
        String accountId = UUID.randomUUID().toString();
        String offerId = UUID.randomUUID().toString();
        String title = "title";
        String description = "description";
        var command = new CreateOfferCommand(AccountId.of(accountId), title, description);
        when(createOfferPort.nextId()).thenReturn(OfferId.of(offerId));
        when(loadClientPort.load(AccountId.of(accountId))).thenReturn(new Client(AccountId.of(accountId)));

        var result = createOfferService.handle(command);

        verify(createOfferPort).save(any(Offer.class));
        ArgumentCaptor<Offer> argument = ArgumentCaptor.forClass(Offer.class);
        verify(createOfferPort).save(argument.capture());
        var savedOffer = argument.getValue();
        assertEquals(accountId, savedOffer.getCreatorAccountId().value());
        assertEquals(offerId, savedOffer.getOfferId().value());
        assertEquals(title, savedOffer.getTitle());
        assertEquals(description, savedOffer.getDescription());

        verify(eventDispatcher).dispatch(any(OfferCreatedApplicationEvent.class));
        ArgumentCaptor<OfferCreatedApplicationEvent> eventArgument = ArgumentCaptor.forClass(OfferCreatedApplicationEvent.class);
        verify(eventDispatcher).dispatch(eventArgument.capture());
        var dispatchedEvent = eventArgument.getValue();
        assertEquals(offerId, dispatchedEvent.getOfferId().value());

        assertEquals(offerId, result);
    }
}
