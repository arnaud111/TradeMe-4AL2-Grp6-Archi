package org.grp2.api.trademe.adapter.in.mapper;

import org.grp2.api.trademe.adapter.in.account.consultant.response.ConsultantResponse;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;

import java.util.List;
import java.util.stream.Collectors;

public class ConsultantApiMapper {

    public static ConsultantResponse consultantToConsultantResponse(Consultant consultant) {
        return new ConsultantResponse(
                consultant.id().value(),
                consultant.getAdr(),
                consultant.getAvailability(),
                consultant.getModality(),
                consultant.getEmail(),
                consultant.getName(),
                consultant.getLastName(),
                consultant.getSkills());
    }

    public static List<ConsultantResponse> consultantsToConsultantResponses(List<Consultant> consultants) {
        return consultants.stream()
                .map(ConsultantApiMapper::consultantToConsultantResponse)
                .collect(Collectors.toList());
    }
}
