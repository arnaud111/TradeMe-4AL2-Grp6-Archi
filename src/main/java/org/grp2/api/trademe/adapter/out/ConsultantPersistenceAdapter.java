package org.grp2.api.trademe.adapter.out;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grp2.api.trademe.application.port.out.CreateConsultantPort;
import org.grp2.api.trademe.application.port.out.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.UpdateConsultantPort;
import org.grp2.api.trademe.domain.Consultant;
import org.grp2.api.trademe.domain.UserId;

import java.util.UUID;
import java.util.stream.Collectors;

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
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        var consultantEntity = new ConsultantEntity(consultant.id().value(),
                consultant.getRecordedEvents().stream().map(event ->
                        new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));
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
