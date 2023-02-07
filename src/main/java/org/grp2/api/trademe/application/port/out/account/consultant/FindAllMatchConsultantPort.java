package org.grp2.api.trademe.application.port.out.account.consultant;

import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;

import java.util.List;

public interface FindAllMatchConsultantPort {

    List<Consultant> findAllMatch(String name, String lastName, Integer adrMin, Integer adrMax);
}
