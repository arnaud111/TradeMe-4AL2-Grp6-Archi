package org.grp2.api.trademe.adapter.in.account.client;

import org.grp2.api.trademe.adapter.in.account.client.request.CreateClientRequest;
import org.grp2.api.trademe.adapter.in.account.client.response.ClientResponse;
import org.grp2.api.trademe.adapter.in.account.client.response.CreateClientResponse;
import org.grp2.api.trademe.adapter.in.mapper.ClientApiMapper;
import org.grp2.api.trademe.adapter.in.mapper.OfferApiMapper;
import org.grp2.api.trademe.adapter.in.offer.response.OfferResponse;
import org.grp2.api.trademe.application.port.in.command.account.client.CreateClientCommand;
import org.grp2.api.trademe.application.port.in.command.account.client.FindAllClientCommand;
import org.grp2.api.trademe.application.port.in.command.offer.FindAllOfferCommand;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.kernel.CommandBus;
import org.grp2.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private ClientController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateClientResponse create(@RequestBody @Valid CreateClientRequest createClientRequest) {
        var accountId = (String) commandBus.post(new CreateClientCommand(
                createClientRequest.getEmail(),
                createClientRequest.getPassword(),
                createClientRequest.getName(),
                createClientRequest.getLastName()));
        return new CreateClientResponse(accountId);
    }

    @GetMapping("/get")
    public List<ClientResponse> getAll() {
        var clients = (List<Client>) commandBus.post(new FindAllClientCommand());
        return ClientApiMapper.clientsToClientResponses(clients);
    }
}
