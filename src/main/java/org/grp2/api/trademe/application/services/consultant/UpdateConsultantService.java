package org.grp2.api.trademe.application.services.consultant;

import org.grp2.api.trademe.application.events.ConsultantUpdatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.consultant.UpdateConsultantCommand;
import org.grp2.api.trademe.application.port.out.consultant.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.consultant.UpdateConsultantPort;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.CommandHandler;
import org.grp2.kernel.Event;
import org.grp2.kernel.EventDispatcher;

public class UpdateConsultantService implements CommandHandler<UpdateConsultantCommand, Consultant> {

    private final UpdateConsultantPort updateConsultantPort;
    private final LoadConsultantPort loadConsultantPort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public UpdateConsultantService(UpdateConsultantPort updateConsultantPort, LoadConsultantPort loadConsultantPort, EventDispatcher<? super Event> eventDispatcher) {
        this.updateConsultantPort = updateConsultantPort;
        this.loadConsultantPort = loadConsultantPort;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant handle(UpdateConsultantCommand command) {
        var accountId = AccountId.of(command.id);
        var consultant = loadConsultantPort.load(accountId);
        if (command.name != null) consultant.setName(command.name);
        if (command.lastName != null) consultant.setLastName(command.lastName);
        if (command.skills != null) consultant.setSkills(command.skills);
        if (command.adr != null) consultant.setAdr(command.adr);
        if (command.availability != null) consultant.setAvailability(command.availability);
        if (command.modality != null) consultant.setModality(command.modality);
        updateConsultantPort.update(consultant);
        eventDispatcher.dispatch(new ConsultantUpdatedApplicationEvent(accountId));
        return consultant;
    }
}
