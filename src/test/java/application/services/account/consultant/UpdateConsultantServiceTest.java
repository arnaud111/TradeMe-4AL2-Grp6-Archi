package application.services.account.consultant;

import org.grp2.api.trademe.application.events.account.consultant.ConsultantUpdatedApplicationEvent;
import org.grp2.api.trademe.application.port.in.command.account.consultant.UpdateConsultantCommand;
import org.grp2.api.trademe.application.port.out.account.consultant.LoadConsultantPort;
import org.grp2.api.trademe.application.port.out.account.consultant.UpdateConsultantPort;
import org.grp2.api.trademe.application.services.account.consultant.UpdateConsultantService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.EventDispatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateConsultantServiceTest {

    @Mock
    private LoadConsultantPort loadConsultantPort;

    @Mock
    private UpdateConsultantPort updateConsultantPort;

    @Mock
    private EventDispatcher eventDispatcher;

    @InjectMocks
    private UpdateConsultantService updateConsultantService;
/*
    @Test
    void shouldUpdateConsultant() {
        AccountId accountId = AccountId.of(UUID.randomUUID());
        ArrayList<String> skills = new ArrayList<>();
        skills.add("test");
        UpdateConsultantCommand command = new UpdateConsultantCommand(accountId.value(), "name", "lastname", 1, "availability", "modality", skills);
        Consultant consultant = new Consultant(accountId, "email", "password", "Nono", "Nono", null, null, null, null);
        Consultant consultantExpected = new Consultant(accountId, "email", "password", "name", "lastname", skills, 1, "availability", "modality");

        when(loadConsultantPort.load(accountId)).thenReturn(consultant);

        Consultant updatedConsultant = updateConsultantService.handle(command);

        assertEquals(consultantExpected.id(), updatedConsultant.id());
        assertEquals(consultantExpected.getName(), updatedConsultant.getName());
        assertEquals(consultantExpected.getLastName(), updatedConsultant.getLastName());
        assertEquals(consultantExpected.getSkills(), updatedConsultant.getSkills());
        assertEquals(consultantExpected.getAdr(), updatedConsultant.getAdr());
        assertEquals(consultantExpected.getAvailability(), updatedConsultant.getAvailability());
        assertEquals(consultantExpected.getModality(), updatedConsultant.getModality());
        verify(updateConsultantPort).update(updatedConsultant);
    }*/
}
