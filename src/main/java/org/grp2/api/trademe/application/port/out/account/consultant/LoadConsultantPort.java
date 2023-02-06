package org.grp2.api.trademe.application.port.out.account.consultant;

import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.api.trademe.domain.dto.account.AccountId;

public interface LoadConsultantPort {

    Consultant load(AccountId accountId);
}
