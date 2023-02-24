package application.services.account.consultant;

import org.grp2.api.trademe.application.port.out.account.consultant.FindAllConsultantPort;
import org.grp2.api.trademe.application.services.account.consultant.FindAllConsultantService;
import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
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
public class FindAllConsultantServiceTest {

    @Mock
    private FindAllConsultantPort findAllConsultantPort;

    @InjectMocks
    private FindAllConsultantService findAllConsultantService;

    @Test
    public void handle_shouldReturnAllConsultants() {
        var consultants = new ArrayList<Consultant>();
        consultants.add(new Consultant(AccountId.of(UUID.randomUUID())));
        consultants.add(new Consultant(AccountId.of(UUID.randomUUID())));
        when(findAllConsultantPort.findAll()).thenReturn(consultants);

        List<Consultant> result = findAllConsultantService.handle(null);

        assertEquals(consultants, result);
    }
}
