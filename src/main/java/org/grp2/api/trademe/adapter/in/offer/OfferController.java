package org.grp2.api.trademe.adapter.in.offer;

import org.grp2.api.trademe.adapter.in.offer.request.CreateOfferRequest;
import org.grp2.api.trademe.adapter.in.offer.response.CreateOfferResponse;
import org.grp2.api.trademe.application.port.in.command.offer.CreateOfferCommand;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.kernel.CommandBus;
import org.grp2.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/offer")
public final class OfferController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private OfferController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateOfferResponse create(@RequestBody @Valid CreateOfferRequest createOfferRequest) {
        var offerId = (String) commandBus.post(new CreateOfferCommand(
                AccountId.of(createOfferRequest.getCreatorAccountId()),
                createOfferRequest.getTitle(),
                createOfferRequest.getDescription()
        ));
        return new CreateOfferResponse(offerId);
    }
}
