package org.grp2.api.trademe.adapter.out.persistence;

import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.grp2.api.trademe.adapter.out.repository.ConsultantEntityRepository;
import org.grp2.api.trademe.adapter.out.mapper.ConsultantEntityMapper;
import org.grp2.api.trademe.application.port.out.account.consultant.*;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ConsultantPersistenceAdapter implements FindAllConsultantPort, FindAllMatchConsultantPort, LoadConsultantPort, UpdateConsultantPort, CreateConsultantPort {

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

    @Override
    public List<Consultant> findAllMatch(String name, String lastName, Integer adrMin, Integer adrMax) {
        Specification<ConsultantEntity> specification = (root, query, builder) -> {
            Predicate predicate = builder.conjunction();
            if (name != null) {
                predicate = builder.and(predicate, builder.like(root.get("name"), "%" + name + "%"));
            }
            if (lastName != null) {
                predicate = builder.and(predicate, builder.like(root.get("lastName"), "%" + lastName + "%"));
            }
            if (adrMin != null) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get("adr"), adrMin));
            }
            if (adrMax != null) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(root.get("adr"), adrMax));
            }
            return predicate;
        };
        return ConsultantEntityMapper.consultantEntitiesToDomainConsultants(consultantEntityRepository.findAll(specification));
    }
}
