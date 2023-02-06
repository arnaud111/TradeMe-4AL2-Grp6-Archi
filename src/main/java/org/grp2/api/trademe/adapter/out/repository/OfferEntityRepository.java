package org.grp2.api.trademe.adapter.out.repository;

import org.grp2.api.trademe.adapter.out.entity.ClientEntity;
import org.grp2.api.trademe.adapter.out.entity.OfferEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferEntityRepository extends CrudRepository<OfferEntity, String> {

    List<OfferEntity> findAll();
}
