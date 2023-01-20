package org.grp2.api.trademe.application.services.consultant;

import org.grp2.api.trademe.application.events.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.consultant.CreateConsultantCommand;
import org.grp2.api.trademe.application.port.out.consultant.CreateConsultantPort;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.CommandHandler;
import org.grp2.kernel.Event;
import org.grp2.kernel.EventDispatcher;

public final class CreateConsultantService implements CommandHandler<CreateConsultantCommand, String> {

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
        createConsultantPort.save(consultant);
        eventDispatcher.dispatch(new ConsultantCreatedApplicationEvent(accountId));
        return accountId.value();
    }
}
