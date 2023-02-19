package application.services.account.client;

import org.grp2.api.trademe.application.port.out.account.client.FindAllClientPort;
import org.grp2.api.trademe.application.services.account.client.FindAllClientService;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindAllClientServiceTest {

    @Mock
    private FindAllClientPort findAllClientPort;

    @InjectMocks
    private FindAllClientService findAllClientService;
/*
    @Test
    public void handle_shouldReturnAllClients() {
        var clients = new ArrayList<Client>();
        clients.add(new Client(UUID.randomUUID(), "jojo@gmail.com", "azerty", "jojo", "jojo"));
        clients.add(new Client(UUID.randomUUID(), "nono@gmail.com", "azerty", "nono", "nono"));
        when(findAllClientPort.findAll()).thenReturn(clients);

        List<Client> result = findAllClientService.handle(null);

        assertEquals(clients, result);
    }*/
}
