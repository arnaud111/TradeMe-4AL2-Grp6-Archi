package org.grp2.api.trademe.application.port.in.usecase.account.client;

import org.grp2.api.trademe.application.port.in.command.account.client.FindByIdClientCommand;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.kernel.CommandHandler;

public interface FindByIdClientUseCase extends CommandHandler<FindByIdClientCommand, Client> {
}
