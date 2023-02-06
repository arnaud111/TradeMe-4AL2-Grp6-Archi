package org.grp2.api.trademe.application.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.grp2.api.trademe.adapter.out.entity.ClientEntity;
import org.grp2.api.trademe.adapter.out.entity.EventEntity;
import org.grp2.api.trademe.adapter.out.entity.OfferEntity;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.api.trademe.domain.dto.offer.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientEntityMapper {

    public static ClientEntity domainClientToClientEntity(Client client) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(client.id().value());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setPassword(client.getPassword());
        clientEntity.setName(client.getName());
        clientEntity.setLastName(client.getLastName());
        clientEntity.setRecordedEvents(client.getRecordedEvents().stream().map(event ->
                new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));

        return clientEntity;
    }

    public static Client clientEntityToDomainClient(ClientEntity clientEntity) {

        Client client = new Client(AccountId.of(clientEntity.getId()));
        client.setEmail(clientEntity.getEmail());
        client.setPassword(clientEntity.getPassword());
        client.setName(clientEntity.getName());
        client.setLastName(clientEntity.getLastName());

        return client;
    }

    public static List<Client> clientEntitiesToDomainClients(List<ClientEntity> clientEntities) {
        List<Client> clients = new ArrayList<>();
        for (ClientEntity clientEntity : clientEntities) {
            clients.add(ClientEntityMapper.clientEntityToDomainClient(clientEntity));
        }
        return clients;
    }
}
