package org.grp2.api.trademe.application.port.out.account.consultant;

import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.api.trademe.domain.dto.account.AccountId;

public interface CreateConsultantPort {

    AccountId nextId();

    void save(Consultant consultant);
}
