package org.grp2.api.trademe.application.port.out.account.client;

import org.grp2.api.trademe.domain.dto.account.client.Client;

import java.util.List;

public interface FindAllClientPort {

    List<Client> findAll();
}
