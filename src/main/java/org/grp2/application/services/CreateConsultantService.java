package org.grp2.application.services;

import org.grp2.application.port.in.CreateConsultantCommand;
import org.grp2.application.port.in.CreateConsultantUseCase;
import org.grp2.application.port.out.CreateConsultantPort;
import org.grp2.domain.Consultant;
import org.grp2.domain.UserId;

public final class CreateConsultantService implements CreateConsultantUseCase {

    private final CreateConsultantPort createConsultantPort;

    public CreateConsultantService(CreateConsultantPort createConsultantPort) {
        this.createConsultantPort = createConsultantPort;
    }

    @Override
    public String handle(CreateConsultantCommand command) {
        var userId = createConsultantPort.nextId();
        var consultant = new Consultant(userId);
        createConsultantPort.save(consultant);
        return userId.value();
    }
}
