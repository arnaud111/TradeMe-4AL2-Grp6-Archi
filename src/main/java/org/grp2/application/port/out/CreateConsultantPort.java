package org.grp2.application.port.out;

import org.grp2.domain.Consultant;
import org.grp2.domain.UserId;

public interface CreateConsultantPort {

    UserId nextId();

    void save(Consultant consultant);
}
