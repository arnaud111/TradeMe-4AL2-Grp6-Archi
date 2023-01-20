package org.grp2.api.trademe.application.port.in.usecase;

import org.grp2.api.trademe.application.port.in.command.FindByIdConsultantCommand;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.CommandHandler;

public interface FindByIdConsultantUseCase extends CommandHandler<FindByIdConsultantCommand, Consultant> {
}
