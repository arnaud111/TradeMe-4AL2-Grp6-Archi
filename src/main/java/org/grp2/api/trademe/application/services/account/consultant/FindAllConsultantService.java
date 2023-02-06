package org.grp2.api.trademe.application.services.account.consultant;

import org.grp2.api.trademe.application.port.in.command.account.consultant.FindAllConsultantCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.consultant.FindAllConsultantUseCase;
import org.grp2.api.trademe.application.port.out.account.consultant.FindAllConsultantPort;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;

import java.util.List;

public class FindAllConsultantService implements FindAllConsultantUseCase {

    private final FindAllConsultantPort findAllConsultantPort;

    public FindAllConsultantService(FindAllConsultantPort findAllConsultantPort) {
        this.findAllConsultantPort = findAllConsultantPort;
    }

    @Override
    public List<Consultant> handle(FindAllConsultantCommand command) {
        return this.findAllConsultantPort.findAll();
    }
}
