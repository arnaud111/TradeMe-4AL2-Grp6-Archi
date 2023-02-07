package org.grp2.api.trademe.application.port.in.usecase.offer;

import org.grp2.api.trademe.application.port.in.command.offer.FindByIdOfferCommand;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.kernel.CommandHandler;

public interface FindByIdOfferUseCase extends CommandHandler<FindByIdOfferCommand, Offer> {
}
