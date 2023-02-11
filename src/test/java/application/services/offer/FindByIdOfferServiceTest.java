package application.services.offer;

import org.grp2.api.trademe.application.port.in.command.account.client.FindByIdClientCommand;
import org.grp2.api.trademe.application.port.in.command.offer.FindByIdOfferCommand;
import org.grp2.api.trademe.application.port.out.account.client.LoadClientPort;
import org.grp2.api.trademe.application.port.out.offer.LoadOfferPort;
import org.grp2.api.trademe.application.services.account.client.FindByIdClientService;
import org.grp2.api.trademe.application.services.offer.FindByIdOfferService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;
import org.grp2.api.trademe.domain.exception.account.client.ClientException;
import org.grp2.api.trademe.domain.exception.offer.OfferException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindByIdOfferServiceTest {
    private FindByIdOfferCommand command;
    private AccountId accountId;
    private OfferId offerId;

    @Mock
    private LoadOfferPort loadOfferPort;

    @InjectMocks
    private FindByIdOfferService findByIdOfferService;

    @BeforeEach
    void setUp() {
        accountId = AccountId.of(UUID.randomUUID());
        offerId = OfferId.of(UUID.randomUUID());
        command = new FindByIdOfferCommand(offerId.value());
    }

    @Test
    void handle_whenOfferExists_shouldReturnOffer() throws ClientException {
        Offer expectedOffer = new Offer(offerId, accountId);
        when(loadOfferPort.load(offerId)).thenReturn(expectedOffer);

        Offer actualOffer = findByIdOfferService.handle(command);

        assertEquals(expectedOffer, actualOffer);
    }

    @Test
    void handle_whenOfferDoesNotExist_shouldThrowOfferException() {
        when(loadOfferPort.load(offerId)).thenReturn(null);

        OfferException exception = assertThrows(OfferException.class, () -> findByIdOfferService.handle(command));

        assertEquals("Offer: " + offerId.value() + " not found.", exception.getMessage());
    }
}
