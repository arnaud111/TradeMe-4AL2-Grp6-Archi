package application.services.account.consultant;

import org.grp2.api.trademe.application.events.account.consultant.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.account.consultant.CreateConsultantCommand;
import org.grp2.api.trademe.application.port.out.account.consultant.CreateConsultantPort;
import org.grp2.api.trademe.application.services.account.consultant.CreateConsultantService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.EventDispatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateConsultantServiceTest {

    @Mock
    private CreateConsultantPort createConsultantPort;
    @Mock
    private EventDispatcher eventDispatcher;

    @InjectMocks
    private CreateConsultantService createConsultantService;
/*
    @Test
    public void handle_withValidCommand_shouldSaveConsultantAndDispatchConsultantCreatedEvent() {
        var accountId = UUID.randomUUID().toString();
        String name = "Nono";
        String lastName = "Nono";
        String password = "azerty";
        String email = "nono@nono.nono";
        Integer adr = null;
        String availability = null;
        String modality = null;
        ArrayList<String> skills = null;
        var command = new CreateConsultantCommand(email, password, name, lastName, adr, availability, modality, skills);
        when(createConsultantPort.nextId()).thenReturn(AccountId.of(accountId));

        var result = createConsultantService.handle(command);

        verify(createConsultantPort).save(any(Consultant.class));
        ArgumentCaptor<Consultant> argument = ArgumentCaptor.forClass(Consultant.class);
        verify(createConsultantPort).save(argument.capture());
        var savedConsultant = argument.getValue();
        assertEquals(accountId, savedConsultant.id().value());
        assertEquals(name, savedConsultant.getName());
        assertEquals(lastName, savedConsultant.getLastName());
        assertEquals(password, savedConsultant.getPassword());
        assertEquals(email, savedConsultant.getEmail());
        assertEquals(adr, savedConsultant.getAdr());
        assertEquals(availability, savedConsultant.getAvailability());
        assertEquals(modality, savedConsultant.getModality());
        assertEquals(skills, savedConsultant.getSkills());

        verify(eventDispatcher).dispatch(any(ConsultantCreatedApplicationEvent.class));
        ArgumentCaptor<ConsultantCreatedApplicationEvent> eventArgument = ArgumentCaptor.forClass(ConsultantCreatedApplicationEvent.class);
        verify(eventDispatcher).dispatch(eventArgument.capture());
        var dispatchedEvent = eventArgument.getValue();
        assertEquals(accountId, dispatchedEvent.getAccountId().value());

        assertEquals(accountId, result);
    }*/
}
