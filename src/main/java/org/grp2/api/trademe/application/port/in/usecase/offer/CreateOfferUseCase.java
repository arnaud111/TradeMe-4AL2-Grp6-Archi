package org.grp2.api.trademe.application.port.in.usecase.offer;

import org.grp2.api.trademe.application.port.in.command.offer.CreateOfferCommand;
import org.grp2.kernel.CommandHandler;

public interface CreateOfferUseCase  extends CommandHandler<CreateOfferCommand, String> {
}
