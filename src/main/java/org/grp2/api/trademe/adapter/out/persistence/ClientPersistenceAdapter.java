package org.grp2.api.trademe.adapter.out.persistence;

import org.grp2.api.trademe.adapter.out.entity.ClientEntity;
import org.grp2.api.trademe.adapter.out.repository.ClientEntityRepository;
import org.grp2.api.trademe.application.mapper.ClientEntityMapper;
import org.grp2.api.trademe.application.mapper.OfferEntityMapper;
import org.grp2.api.trademe.application.port.out.account.client.CreateClientPort;
import org.grp2.api.trademe.application.port.out.account.client.FindAllClientPort;
import org.grp2.api.trademe.application.port.out.account.client.LoadClientPort;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientPersistenceAdapter implements CreateClientPort, LoadClientPort, FindAllClientPort {

    private final ClientEntityRepository clientEntityRepository;

    public ClientPersistenceAdapter(ClientEntityRepository clientEntityRepository) {
        this.clientEntityRepository = clientEntityRepository;
    }

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public void save(Client client) {
        ClientEntity clientEntity = ClientEntityMapper.domainClientToClientEntity(client);
        clientEntityRepository.save(clientEntity);
    }

    @Override
    public Client load(AccountId accountId) {
        Optional<ClientEntity> clientEntity = clientEntityRepository.findById(accountId.value());
        if (clientEntity.isEmpty()) return null;
        return ClientEntityMapper.clientEntityToDomainClient(clientEntity.get());
    }

    @Override
    public List<Client> findAll() {
        return ClientEntityMapper.clientEntitiesToDomainClients(clientEntityRepository.findAll());
    }
}
