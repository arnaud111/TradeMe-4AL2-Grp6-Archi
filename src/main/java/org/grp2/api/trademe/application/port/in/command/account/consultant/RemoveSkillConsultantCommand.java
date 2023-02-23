package org.grp2.api.trademe.application.port.in.command.account.consultant;

import org.grp2.kernel.Command;

import javax.validation.constraints.NotNull;

public class RemoveSkillConsultantCommand implements Command {

    @NotNull
    public final String id;
    @NotNull
    public final String skill;

    public RemoveSkillConsultantCommand(String id, String skill) {
        this.id = id;
        this.skill = skill;
    }
}
