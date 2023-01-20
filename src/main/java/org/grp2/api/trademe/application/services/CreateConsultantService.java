package org.grp2.api.trademe.application.services;

import org.grp2.api.trademe.application.events.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.CreateConsultantCommand;
import org.grp2.api.trademe.application.port.out.CreateConsultantPort;
import org.grp2.api.trademe.domain.dto.user.consultant.Consultant;
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
        var userId = createConsultantPort.nextId();
        var consultant = new Consultant(userId);
        consultant.setName(command.name);
        consultant.setLastName(command.lastName);
        consultant.setPassword(command.password);
        consultant.setEmail(command.email);
        createConsultantPort.save(consultant);
        eventDispatcher.dispatch(new ConsultantCreatedApplicationEvent(userId));
        return userId.value();
    }
}
