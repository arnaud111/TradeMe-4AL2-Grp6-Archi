package application.services.account.consultant;

import org.grp2.api.trademe.application.port.in.command.account.consultant.FindAllMatchConsultantCommand;
import org.grp2.api.trademe.application.port.out.account.consultant.FindAllMatchConsultantPort;
import org.grp2.api.trademe.application.services.account.consultant.FindAllMatchConsultantService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindAllMatchConsultantServiceTest {

    @InjectMocks
    private FindAllMatchConsultantService service;

    @Mock
    private FindAllMatchConsultantPort findAllMatchConsultantPort;
/*
    @Test
    public void testHandle() {
        String name = "Nono";
        String lastName = "Nono";
        Integer adrMin = 1;
        Integer adrMax = 100;
        FindAllMatchConsultantCommand command = new FindAllMatchConsultantCommand(name, lastName, adrMin, adrMax);

        Consultant consultant1 = new Consultant(AccountId.of(UUID.randomUUID()), "nono@nono.gmail", "password", "Nono", "Nono", null, 50, null, null);
        Consultant consultant2 = new Consultant(AccountId.of(UUID.randomUUID()), "nono@nono.gmail", "password", "Nono", "Nono", null, 75, null, null);
        List<Consultant> expectedConsultants = Arrays.asList(consultant1, consultant2);

        when(findAllMatchConsultantPort.findAllMatch(name, lastName, adrMin, adrMax)).thenReturn(expectedConsultants);

        List<Consultant> actualConsultants = service.handle(command);

        assertEquals(expectedConsultants, actualConsultants);
    }*/
}
