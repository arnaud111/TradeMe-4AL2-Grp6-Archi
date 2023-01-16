package org.grp2.api.trademe.application.port.out;

import org.grp2.api.trademe.domain.dto.user.consultant.Consultant;
import org.grp2.api.trademe.domain.dto.user.UserId;

public interface CreateConsultantPort {

    UserId nextId();

    void save(Consultant consultant);
}
