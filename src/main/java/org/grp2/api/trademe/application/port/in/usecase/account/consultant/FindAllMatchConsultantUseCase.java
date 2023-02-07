package org.grp2.api.trademe.application.port.in.usecase.account.consultant;

import org.grp2.api.trademe.application.port.in.command.account.consultant.FindAllMatchConsultantCommand;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.CommandHandler;

import java.util.List;

public interface FindAllMatchConsultantUseCase extends CommandHandler<FindAllMatchConsultantCommand, List<Consultant>> {
}
