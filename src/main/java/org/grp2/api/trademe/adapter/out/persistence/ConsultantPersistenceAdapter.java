package org.grp2.api.trademe.adapter.out.persistence;

import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.grp2.api.trademe.adapter.out.repository.ConsultantEntityRepository;
import org.grp2.api.trademe.application.mapper.ConsultantMapper;
import org.grp2.api.trademe.application.port.out.CreateConsultantPort;
import org.grp2.api.trademe.application.port.out.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.UpdateConsultantPort;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.api.trademe.domain.dto.account.AccountId;

import java.util.Optional;
import java.util.UUID;

public class ConsultantPersistenceAdapter implements LoadConsultantPort, UpdateConsultantPort, CreateConsultantPort {

    private final ConsultantEntityRepository consultantEntityRepository;

    public ConsultantPersistenceAdapter(ConsultantEntityRepository consultantEntityRepository) {
        this.consultantEntityRepository = consultantEntityRepository;
    }

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public void save(Consultant consultant) {
        ConsultantEntity consultantEntity = ConsultantMapper.domainConsultantToConsultantEntity(consultant);
        consultantEntityRepository.save(consultantEntity);
    }

    @Override
    public Consultant load(AccountId accountId) {
        Optional<ConsultantEntity> consultantEntity = consultantEntityRepository.findById(accountId.value());
        if (consultantEntity.isEmpty()) return null;
        return ConsultantMapper.consultantEntityToDomainConsultant(consultantEntity.get());
    }

    @Override
    public void update(Consultant consultant) {

    }
}
