package org.grp2.api.trademe.application.port.in.command.account.consultant;

import org.grp2.kernel.Command;

import javax.validation.constraints.NotNull;

public class FindByIdConsultantCommand implements Command {

    @NotNull
    public final String id;

    public FindByIdConsultantCommand(String id) {
        this.id = id;
    }
}
