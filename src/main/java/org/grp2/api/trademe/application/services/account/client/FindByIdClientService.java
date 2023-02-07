package org.grp2.api.trademe.application.services.account.client;

import org.grp2.api.trademe.application.port.in.command.account.client.FindByIdClientCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.client.FindByIdClientUseCase;
import org.grp2.api.trademe.application.port.out.account.client.LoadClientPort;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.api.trademe.domain.exception.account.client.ClientException;

public class FindByIdClientService implements FindByIdClientUseCase {

    private final LoadClientPort loadClientPort;

    public FindByIdClientService(LoadClientPort loadClientPort) {
        this.loadClientPort = loadClientPort;
    }

    @Override
    public Client handle(FindByIdClientCommand command) {
        AccountId accountId = AccountId.of(command.id);
        Client client = this.loadClientPort.load(accountId);
        if (client == null) throw ClientException.notFoundAccountId(accountId);
        return client;
    }
}
