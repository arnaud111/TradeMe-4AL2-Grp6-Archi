package org.grp2.api.trademe.application.services.account.consultant;

import org.grp2.api.trademe.application.events.account.consultant.ConsultantUpdatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.account.consultant.AddSkillConsultantCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.consultant.AddSkillConsultantUseCase;
import org.grp2.api.trademe.application.port.out.account.consultant.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.account.consultant.UpdateConsultantPort;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.Event;
import org.grp2.kernel.EventDispatcher;

public class AddSkillConsultantService implements AddSkillConsultantUseCase {

    private final UpdateConsultantPort updateConsultantPort;
    private final LoadConsultantPort loadConsultantPort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public AddSkillConsultantService(UpdateConsultantPort updateConsultantPort, LoadConsultantPort loadConsultantPort, EventDispatcher<? super Event> eventDispatcher) {
        this.updateConsultantPort = updateConsultantPort;
        this.loadConsultantPort = loadConsultantPort;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant handle(AddSkillConsultantCommand command) {
        var accountId = AccountId.of(command.id);
        var consultant = loadConsultantPort.load(accountId);
        if (!consultant.getSkills().contains(command.skill))
            consultant.addSkill(command.skill);
        ConsultantUpdatedApplicationEvent consultantUpdatedApplicationEvent = new ConsultantUpdatedApplicationEvent(accountId);
        consultant.addRecordedEvents(consultantUpdatedApplicationEvent);
        updateConsultantPort.update(consultant);
        eventDispatcher.dispatch(consultantUpdatedApplicationEvent);
        return consultant;
    }
}
