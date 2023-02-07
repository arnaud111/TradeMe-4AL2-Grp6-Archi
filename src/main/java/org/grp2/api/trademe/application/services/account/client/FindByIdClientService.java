package org.grp2.api.trademe.application.services.account.client;

import org.grp2.api.trademe.application.port.in.command.account.client.FindByIdClientCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.client.FindByIdClientUseCase;
import org.grp2.api.trademe.application.port.out.account.client.LoadClientPort;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;

public class FindByIdClientService implements FindByIdClientUseCase {

    private final LoadClientPort loadClientPort;

    public FindByIdClientService(LoadClientPort loadClientPort) {
        this.loadClientPort = loadClientPort;
    }

    @Override
    public Client handle(FindByIdClientCommand command) {
        return this.loadClientPort.load(AccountId.of(command.id));
    }
}
