package org.grp2.api.trademe.application.port.in.usecase.account.client;

import org.grp2.api.trademe.application.port.in.command.account.client.FindAllClientCommand;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.kernel.CommandHandler;

import java.util.List;

public interface FindAllClientUseCase extends CommandHandler<FindAllClientCommand, List<Client>> {
}
