package org.grp2.api.trademe.application.services.account.consultant;

import org.grp2.api.trademe.application.events.account.consultant.ConsultantUpdatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.account.consultant.RemoveSkillConsultantCommand;
import org.grp2.api.trademe.application.port.in.usecase.account.consultant.RemoveSkillConsultantUseCase;
import org.grp2.api.trademe.application.port.out.account.consultant.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.account.consultant.UpdateConsultantPort;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.Event;
import org.grp2.kernel.EventDispatcher;

public class RemoveSkillConsultantService implements RemoveSkillConsultantUseCase {

    private final UpdateConsultantPort updateConsultantPort;
    private final LoadConsultantPort loadConsultantPort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public RemoveSkillConsultantService(UpdateConsultantPort updateConsultantPort, LoadConsultantPort loadConsultantPort, EventDispatcher<? super Event> eventDispatcher) {
        this.updateConsultantPort = updateConsultantPort;
        this.loadConsultantPort = loadConsultantPort;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Consultant handle(RemoveSkillConsultantCommand command) {
        var accountId = AccountId.of(command.id);
        var consultant = loadConsultantPort.load(accountId);
        if (consultant.getSkills().contains(command.skill))
            consultant.removeSkill(command.skill);
        ConsultantUpdatedApplicationEvent consultantUpdatedApplicationEvent = new ConsultantUpdatedApplicationEvent(accountId);
        consultant.addRecordedEvents(consultantUpdatedApplicationEvent);
        updateConsultantPort.update(consultant);
        eventDispatcher.dispatch(consultantUpdatedApplicationEvent);
        return consultant;
    }
}
