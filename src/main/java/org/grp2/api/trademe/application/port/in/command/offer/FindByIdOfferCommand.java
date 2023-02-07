package org.grp2.api.trademe.application.port.in.command.offer;

import org.grp2.kernel.Command;

import javax.validation.constraints.NotNull;

public class FindByIdOfferCommand implements Command {

    @NotNull
    public final String id;

    public FindByIdOfferCommand(String id) {
        this.id = id;
    }
}
