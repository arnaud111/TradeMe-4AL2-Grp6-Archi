package org.grp2.api.trademe.application.port.out;

import org.grp2.api.trademe.domain.Consultant;
import org.grp2.api.trademe.domain.UserId;

public interface LoadConsultantPort {

    Consultant load(UserId userId);
}
