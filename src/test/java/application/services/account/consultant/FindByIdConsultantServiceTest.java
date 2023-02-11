package application.services.account.consultant;

import org.grp2.api.trademe.application.port.in.command.account.client.FindByIdClientCommand;
import org.grp2.api.trademe.application.port.in.command.account.consultant.FindByIdConsultantCommand;
import org.grp2.api.trademe.application.port.out.account.client.LoadClientPort;
import org.grp2.api.trademe.application.port.out.account.consultant.LoadConsultantPort;
import org.grp2.api.trademe.application.services.account.client.FindByIdClientService;
import org.grp2.api.trademe.application.services.account.consultant.FindByIdConsultantService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.client.Client;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.api.trademe.domain.exception.account.client.ClientException;
import org.grp2.api.trademe.domain.exception.account.consultant.ConsultantException;
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
public class FindByIdConsultantServiceTest {
    private FindByIdConsultantCommand command;
    private AccountId accountId;

    @Mock
    private LoadConsultantPort loadConsultantPort;

    @InjectMocks
    private FindByIdConsultantService findByIdConsultantService;

    @BeforeEach
    void setUp() {
        accountId = AccountId.of(UUID.randomUUID());
        command = new FindByIdConsultantCommand(accountId.value());
    }

    @Test
    void handle_whenConsultantExists_shouldReturnConsultant() throws ClientException {
        Consultant expectedConsultant = new Consultant(accountId);
        when(loadConsultantPort.load(accountId)).thenReturn(expectedConsultant);

        Consultant actualClient = findByIdConsultantService.handle(command);

        assertEquals(expectedConsultant, actualClient);
    }

    @Test
    void handle_whenConsultantDoesNotExist_shouldThrowConsultantException() {
        when(loadConsultantPort.load(accountId)).thenReturn(null);

        ConsultantException exception = assertThrows(ConsultantException.class, () -> findByIdConsultantService.handle(command));

        assertEquals("Consultant: " + accountId.value() + " not found.", exception.getMessage());
    }
}
