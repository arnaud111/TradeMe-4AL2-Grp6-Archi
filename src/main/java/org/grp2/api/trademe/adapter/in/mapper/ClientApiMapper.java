package org.grp2.api.trademe.adapter.in.mapper;

import org.grp2.api.trademe.adapter.in.controller.account.client.response.ClientResponse;
import org.grp2.api.trademe.domain.dto.account.client.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientApiMapper {

    public static ClientResponse clientToClientResponse(Client client) {

        if (client == null) return null;

        return new ClientResponse(
                client.id().value(),
                client.getEmail(),
                client.getName(),
                client.getLastName()
        );
    }

    public static List<ClientResponse> clientsToClientResponses(List<Client> clients) {

        if (clients == null) return null;

        return clients.stream()
                .map(ClientApiMapper::clientToClientResponse)
                .collect(Collectors.toList());
    }
}
