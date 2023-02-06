package org.grp2.api.trademe.application.port.in.usecase.account.client;

import org.grp2.api.trademe.application.port.in.command.account.client.CreateClientCommand;
import org.grp2.kernel.CommandHandler;

public interface CreateClientUseCase extends CommandHandler<CreateClientCommand, String> {
}
