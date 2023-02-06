package org.grp2.api.trademe.application.services.account.client;

import org.grp2.api.trademe.application.port.in.command.account.client.FindAllClientCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.client.FindAllClientUseCase;
import org.grp2.api.trademe.application.port.out.account.client.FindAllClientPort;
import org.grp2.api.trademe.domain.dto.account.client.Client;

import java.util.List;

public class FindAllClientService implements FindAllClientUseCase {

    private final FindAllClientPort findAllClientPort;

    public FindAllClientService(FindAllClientPort findAllClientPort) {
        this.findAllClientPort = findAllClientPort;
    }

    @Override
    public List<Client> handle(FindAllClientCommand command) {
        return this.findAllClientPort.findAll();
    }
}
