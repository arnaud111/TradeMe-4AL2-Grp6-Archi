package org.grp2.api.trademe.application.port.in.usecase.offer;

import org.grp2.api.trademe.application.port.in.command.offer.FindAllOfferCommand;
import org.grp2.api.trademe.domain.dto.offer.Offer;
import org.grp2.kernel.CommandHandler;

import java.util.List;

public interface FindAllOfferUseCase extends CommandHandler<FindAllOfferCommand, List<Offer>> {
}
