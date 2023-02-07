package org.grp2.api.trademe.application.port.in.command.account.client;

import org.grp2.kernel.Command;

import javax.validation.constraints.NotNull;

public class FindByIdClientCommand implements Command {

    @NotNull
    public final String id;

    public FindByIdClientCommand(String id) {
        this.id = id;
    }
}
