package org.grp2.api.trademe.application.services.consultant;

import org.grp2.api.trademe.application.port.in.command.consultant.FindByIdConsultantCommand;
import org.grp2.api.trademe.application.port.out.consultant.LoadConsultantPort;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.CommandHandler;

public class FindByIdConsultantService implements CommandHandler<FindByIdConsultantCommand, Consultant> {

    private final LoadConsultantPort loadConsultantPort;

    public FindByIdConsultantService(LoadConsultantPort loadConsultantPort) {
        this.loadConsultantPort = loadConsultantPort;
    }

    @Override
    public Consultant handle(FindByIdConsultantCommand command) {
        return this.loadConsultantPort.load(AccountId.of(command.id));
    }
}
