package org.grp2.api.trademe.application.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.grp2.api.trademe.adapter.out.entity.EventEntity;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

public class ConsultantMapper {

    public static ConsultantEntity domainConsultantToConsultantEntity(Consultant consultant) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();

        ConsultantEntity consultantEntity = new ConsultantEntity();
        consultantEntity.setAdr(consultant.getAdr());
        consultantEntity.setAvailability(consultant.getAvailability());
        consultantEntity.setModality(consultant.getModality());
        consultantEntity.setId(consultant.id().value());
        consultantEntity.setEmail(consultant.getEmail());
        consultantEntity.setPassword(consultant.getPassword());
        consultantEntity.setName(consultant.getName());
        consultantEntity.setLastName(consultant.getLastName());
        consultantEntity.setSkills(consultant.getSkills());
        consultantEntity.setRecordedEvents(consultant.getRecordedEvents().stream().map(event ->
                new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));

        return consultantEntity;
    }

    public static Consultant consultantEntityToDomainConsultant(ConsultantEntity consultantEntity) {

        Consultant consultant = new Consultant(new AccountId(UUID.randomUUID()));
        consultant.setAdr(consultantEntity.getAdr());
        consultant.setAvailability(consultantEntity.getAvailability());
        consultant.setModality(consultantEntity.getModality());
        consultant.setEmail(consultantEntity.getEmail());
        consultant.setPassword(consultantEntity.getPassword());
        consultant.setName(consultantEntity.getName());
        consultant.setLastName(consultantEntity.getLastName());
        consultant.setSkills(new ArrayList<>(consultantEntity.getSkills()));

        return consultant;
    }
}
