package org.grp2.api.trademe.application.services.account.client;

import org.grp2.api.trademe.application.events.account.client.ClientCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.account.client.CreateClientCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.client.CreateClientUseCase;
import org.grp2.api.trademe.application.port.out.account.client.CreateClientPort;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.kernel.Event;
import org.grp2.kernel.EventDispatcher;

public class CreateClientService implements CreateClientUseCase {

    private final CreateClientPort createClientPort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public CreateClientService(CreateClientPort createClientPort, EventDispatcher<? super Event> eventDispatcher) {
        this.createClientPort = createClientPort;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String handle(CreateClientCommand command) {
        var accountId = createClientPort.nextId();
        var client = new Client(accountId);
        client.setName(command.name);
        client.setLastName(command.lastName);
        client.setPassword(command.password);
        client.setEmail(command.email);
        createClientPort.save(client);
        eventDispatcher.dispatch(new ClientCreatedApplicationEvent(accountId));
        return accountId.value();
    }
}
