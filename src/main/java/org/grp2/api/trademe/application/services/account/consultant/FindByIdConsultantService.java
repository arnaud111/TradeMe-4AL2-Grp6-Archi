package org.grp2.api.trademe.application.services.account.consultant;

import org.grp2.api.trademe.application.port.in.command.account.consultant.FindByIdConsultantCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.consultant.FindByIdConsultantUseCase;
import org.grp2.api.trademe.application.port.out.account.consultant.LoadConsultantPort;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.api.trademe.domain.exception.account.consultant.ConsultantException;

public class FindByIdConsultantService implements FindByIdConsultantUseCase {

    private final LoadConsultantPort loadConsultantPort;

    public FindByIdConsultantService(LoadConsultantPort loadConsultantPort) {
        this.loadConsultantPort = loadConsultantPort;
    }

    @Override
    public Consultant handle(FindByIdConsultantCommand command) throws ConsultantException {
        AccountId accountId = AccountId.of(command.id);
        Consultant consultant = this.loadConsultantPort.load(accountId);
        if (consultant == null) throw ConsultantException.notFoundAccountId(accountId);
        return consultant;
    }
}
