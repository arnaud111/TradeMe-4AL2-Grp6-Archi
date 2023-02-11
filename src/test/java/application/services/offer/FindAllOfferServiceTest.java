package application.services.offer;

import org.grp2.api.trademe.application.port.out.offer.FindAllOfferPort;
import org.grp2.api.trademe.application.services.offer.FindAllOfferService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.api.trademe.domain.dto.offer.OfferId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindAllOfferServiceTest {

    @Mock
    private FindAllOfferPort findAllOfferPort;

    @InjectMocks
    private FindAllOfferService findAllOfferService;

    @Test
    public void handle_shouldReturnAllOffers() {
        var offers = new ArrayList<Offer>();
        offers.add(new Offer(OfferId.of(UUID.randomUUID()), AccountId.of(UUID.randomUUID())));
        offers.add(new Offer(OfferId.of(UUID.randomUUID()), AccountId.of(UUID.randomUUID())));
        when(findAllOfferPort.findAll()).thenReturn(offers);

        List<Offer> result = findAllOfferService.handle(null);

        assertEquals(offers, result);
    }
}
