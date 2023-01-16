package org.grp2.api.trademe.adapter.out;

import org.grp2.api.trademe.application.port.out.CreateConsultantPort;
import org.grp2.api.trademe.application.port.out.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.UpdateConsultantPort;
import org.grp2.api.trademe.domain.dto.user.consultant.Consultant;
import org.grp2.api.trademe.domain.exception.user.UserException;
import org.grp2.api.trademe.domain.dto.user.UserId;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class InMemoryConsultantPersistenceAdapter implements LoadConsultantPort, UpdateConsultantPort, CreateConsultantPort {

    private final Map<UserId, Consultant> registry = new HashMap<>();

    @Override
    public UserId nextId() {
        return UserId.of(UUID.randomUUID());
    }

    @Override
    public void save(Consultant consultant) {
        registry.put(consultant.id(), consultant);
    }

    @Override
    public Consultant load(UserId userId) {
        return registry.computeIfAbsent(userId,
                key -> {
                    throw UserException.notFoundUserId(userId);
                });
    }

    @Override
    public void update(Consultant consultant) {
        registry.put(consultant.id(), consultant);
    }
}
