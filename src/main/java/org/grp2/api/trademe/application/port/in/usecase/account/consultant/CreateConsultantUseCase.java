package org.grp2.api.trademe.application.port.in.usecase.account.consultant;

import org.grp2.api.trademe.application.port.in.command.account.consultant.CreateConsultantCommand;
import org.grp2.kernel.CommandHandler;

public interface CreateConsultantUseCase extends CommandHandler<CreateConsultantCommand, String> {

}
