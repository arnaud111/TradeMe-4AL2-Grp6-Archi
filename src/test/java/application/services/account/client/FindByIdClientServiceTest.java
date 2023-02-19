package application.services.account.client;

import org.grp2.api.trademe.application.port.in.command.account.client.FindByIdClientCommand;
import org.grp2.api.trademe.application.port.out.account.client.LoadClientPort;
import org.grp2.api.trademe.application.services.account.client.FindByIdClientService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.api.trademe.domain.exception.account.client.ClientException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindByIdClientServiceTest {
    private FindByIdClientCommand command;
    private AccountId accountId;

    @Mock
    private LoadClientPort loadClientPort;

    @InjectMocks
    private FindByIdClientService findByIdClientService;

    @BeforeEach
    void setUp() {
        accountId = AccountId.of(UUID.randomUUID());
        command = new FindByIdClientCommand(accountId.value());
    }
/*
    @Test
    void handle_whenClientExists_shouldReturnClient() throws ClientException {
        Client expectedClient = new Client(accountId);
        when(loadClientPort.load(accountId)).thenReturn(expectedClient);

        Client actualClient = findByIdClientService.handle(command);

        assertEquals(expectedClient, actualClient);
    }

    @Test
    void handle_whenClientDoesNotExist_shouldThrowClientException() {
        when(loadClientPort.load(accountId)).thenReturn(null);

        ClientException exception = assertThrows(ClientException.class, () -> findByIdClientService.handle(command));

        assertEquals("Client: " + accountId.value() + " not found.", exception.getMessage());
    }*/
}