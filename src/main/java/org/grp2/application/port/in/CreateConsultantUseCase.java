package org.grp2.application.port.in;

import org.grp2.domain.UserId;

public interface CreateConsultantUseCase {

    UserId handle(CreateConsultantCommand command);
}
