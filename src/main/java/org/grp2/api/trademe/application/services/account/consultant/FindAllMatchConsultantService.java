package org.grp2.api.trademe.application.services.account.consultant;

import org.grp2.api.trademe.application.port.in.command.account.consultant.FindAllMatchConsultantCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.consultant.FindAllMatchConsultantUseCase;
import org.grp2.api.trademe.application.port.out.account.consultant.FindAllMatchConsultantPort;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;

import java.util.List;

public class FindAllMatchConsultantService implements FindAllMatchConsultantUseCase {

    private final FindAllMatchConsultantPort findAllMatchConsultantPort;

    public FindAllMatchConsultantService(FindAllMatchConsultantPort findAllMatchConsultantPort) {
        this.findAllMatchConsultantPort = findAllMatchConsultantPort;
    }

    @Override
    public List<Consultant> handle(FindAllMatchConsultantCommand command) {
        return this.findAllMatchConsultantPort.findAllMatch(
                command.name,
                command.lastName,
                command.adrMin,
                command.adrMax
        );
    }
}
