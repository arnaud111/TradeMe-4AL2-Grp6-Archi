package org.grp2.application.port.out;

import org.grp2.domain.Consultant;
import org.grp2.domain.UserId;

public interface LoadConsultantPort {

    Consultant load(UserId userId);
}
