package org.grp2.api.trademe.adapter.out;

import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.grp2.api.trademe.adapter.out.repository.ConsultantEntityRepository;
import org.grp2.api.trademe.application.mapper.ConsultantMapper;
import org.grp2.api.trademe.application.port.out.CreateConsultantPort;
import org.grp2.api.trademe.application.port.out.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.UpdateConsultantPort;
import org.grp2.api.trademe.domain.dto.user.consultant.Consultant;
import org.grp2.api.trademe.domain.dto.user.UserId;

import java.util.UUID;

public class ConsultantPersistenceAdapter implements LoadConsultantPort, UpdateConsultantPort, CreateConsultantPort {

    private final ConsultantEntityRepository consultantEntityRepository;

    public ConsultantPersistenceAdapter(ConsultantEntityRepository consultantEntityRepository) {
        this.consultantEntityRepository = consultantEntityRepository;
    }

    @Override
    public UserId nextId() {
        return UserId.of(UUID.randomUUID());
    }

    @Override
    public void save(Consultant consultant) {
        ConsultantEntity consultantEntity = ConsultantMapper.domainConsultantToConsultantEntity(consultant);
        consultantEntityRepository.save(consultantEntity);
    }

    @Override
    public Consultant load(UserId userId) {
        return null;
    }

    @Override
    public void update(Consultant consultant) {

    }
}
