package org.grp2.api.trademe.application.port.out;

import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;

public interface UpdateConsultantPort {

    void update(Consultant consultant);
}
