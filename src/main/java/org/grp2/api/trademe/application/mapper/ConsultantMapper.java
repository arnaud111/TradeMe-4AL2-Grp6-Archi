package org.grp2.api.trademe.application.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grp2.api.trademe.adapter.out.entity.ConsultantEntity;
import org.grp2.api.trademe.adapter.out.entity.EventEntity;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;

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
        consultantEntity.setRecordedEvents(consultant.getRecordedEvents().stream().map(event ->
                new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));

        return consultantEntity;
    }
}
