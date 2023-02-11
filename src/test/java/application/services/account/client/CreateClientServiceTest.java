package application.services.account.client;

import org.grp2.api.trademe.application.events.account.client.ClientCreatedApplicationEvent;
import org.grp2.api.trademe.application.events.account.consultant.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.account.client.CreateClientCommand;
import org.grp2.api.trademe.application.port.out.account.client.CreateClientPort;
import org.grp2.api.trademe.application.services.account.client.CreateClientService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.kernel.EventDispatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateClientServiceTest {

    @Mock
    private CreateClientPort createClientPort;
    @Mock
    private EventDispatcher eventDispatcher;

    @InjectMocks
    private CreateClientService createClientService;

    @Test
    public void handle_withValidCommand_shouldSaveClientAndDispatchClientCreatedEvent() {
        var accountId = UUID.randomUUID().toString();
        var name = "Nono";
        var lastName = "Nono";
        var password = "azerty";
        var email = "nono@nono.nono";
        var command = new CreateClientCommand(email, password, name, lastName);
        when(createClientPort.nextId()).thenReturn(AccountId.of(accountId));

        var result = createClientService.handle(command);

        verify(createClientPort).save(any(Client.class));
        ArgumentCaptor<Client> argument = ArgumentCaptor.forClass(Client.class);
        verify(createClientPort).save(argument.capture());
        var savedClient = argument.getValue();
        assertEquals(accountId, savedClient.id().value());
        assertEquals(name, savedClient.getName());
        assertEquals(lastName, savedClient.getLastName());
        assertEquals(password, savedClient.getPassword());
        assertEquals(email, savedClient.getEmail());

        verify(eventDispatcher).dispatch(any(ClientCreatedApplicationEvent.class));
        ArgumentCaptor<ClientCreatedApplicationEvent> eventArgument = ArgumentCaptor.forClass(ClientCreatedApplicationEvent.class);
        verify(eventDispatcher).dispatch(eventArgument.capture());
        var dispatchedEvent = eventArgument.getValue();
        assertEquals(accountId, dispatchedEvent.getAccountId().value());

        assertEquals(accountId, result);
    }
}
