package org.grp2.api.trademe.adapter.in.account.client;

import org.grp2.api.trademe.adapter.in.account.client.request.CreateClientRequest;
import org.grp2.api.trademe.adapter.in.account.client.response.CreateClientResponse;
import org.grp2.api.trademe.application.port.in.command.account.client.CreateClientCommand;
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
}
