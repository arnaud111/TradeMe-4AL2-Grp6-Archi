package org.grp2.api.trademe.application.port.in.command.offer;

import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.kernel.Command;

import javax.validation.constraints.NotNull;

public class CreateOfferCommand implements Command {

    @NotNull
    public final AccountId creatorAccountId;
    @NotNull
    public final String title;
    @NotNull
    public final String description;

    public CreateOfferCommand(AccountId creatorAccountId, String title, String description) {
        this.creatorAccountId = creatorAccountId;
        this.title = title;
        this.description = description;
    }
}
