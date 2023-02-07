package org.grp2.api.trademe.adapter.out.persistence;

import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.grp2.api.trademe.adapter.out.repository.ConsultantEntityRepository;
import org.grp2.api.trademe.adapter.out.mapper.ConsultantEntityMapper;
import org.grp2.api.trademe.application.port.out.account.consultant.CreateConsultantPort;
import org.grp2.api.trademe.application.port.out.account.consultant.FindAllConsultantPort;
import org.grp2.api.trademe.application.port.out.account.consultant.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.account.consultant.UpdateConsultantPort;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.api.trademe.domain.dto.account.AccountId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ConsultantPersistenceAdapter implements FindAllConsultantPort, LoadConsultantPort, UpdateConsultantPort, CreateConsultantPort {

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
        ConsultantEntity consultantEntity = ConsultantEntityMapper.domainConsultantToConsultantEntity(consultant);
        consultantEntityRepository.save(consultantEntity);
    }

    @Override
    public Consultant load(AccountId accountId) {
        Optional<ConsultantEntity> consultantEntity = consultantEntityRepository.findById(accountId.value());
        if (consultantEntity.isEmpty()) return null;
        return ConsultantEntityMapper.consultantEntityToDomainConsultant(consultantEntity.get());
    }

    @Override
    public void update(Consultant consultant) {
        ConsultantEntity consultantEntityToSave = ConsultantEntityMapper.domainConsultantToConsultantEntity(consultant);
        Optional<ConsultantEntity> consultantEntityToUpdate = consultantEntityRepository.findById(consultantEntityToSave.getId());
        if (consultantEntityToUpdate.isEmpty()) return;
        consultantEntityRepository.save(consultantEntityToSave);
    }

    @Override
    public List<Consultant> findAll() {
        return ConsultantEntityMapper.consultantEntitiesToDomainConsultants(consultantEntityRepository.findAll());
    }
}
