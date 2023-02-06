package org.grp2.api.trademe.application.services.account.consultant;

import org.grp2.api.trademe.application.events.account.consultant.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.account.consultant.CreateConsultantCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.consultant.CreateConsultantUseCase;
import org.grp2.api.trademe.application.port.out.account.consultant.CreateConsultantPort;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.CommandHandler;
import org.grp2.kernel.Event;
import org.grp2.kernel.EventDispatcher;

public final class CreateConsultantService implements CreateConsultantUseCase {

    private final CreateConsultantPort createConsultantPort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public CreateConsultantService(CreateConsultantPort createConsultantPort, EventDispatcher<? super Event> eventDispatcher) {
        this.createConsultantPort = createConsultantPort;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String handle(CreateConsultantCommand command) {
        var accountId = createConsultantPort.nextId();
        var consultant = new Consultant(accountId);
        consultant.setName(command.name);
        consultant.setLastName(command.lastName);
        consultant.setPassword(command.password);
        consultant.setEmail(command.email);
        consultant.setAdr(command.adr);
        consultant.setAvailability(command.availability);
        consultant.setModality(command.modality);
        consultant.setSkills(command.skills);
        createConsultantPort.save(consultant);
        eventDispatcher.dispatch(new ConsultantCreatedApplicationEvent(accountId));
        return accountId.value();
    }
}
