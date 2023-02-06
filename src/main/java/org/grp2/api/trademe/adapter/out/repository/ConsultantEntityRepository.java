package org.grp2.api.trademe.adapter.out.repository;

import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultantEntityRepository extends CrudRepository<ConsultantEntity, String> {

    List<ConsultantEntity> findAll();
}
