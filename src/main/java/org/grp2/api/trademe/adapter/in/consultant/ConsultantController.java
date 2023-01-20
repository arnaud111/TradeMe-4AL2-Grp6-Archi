package org.grp2.api.trademe.adapter.in.consultant;

import org.grp2.api.trademe.adapter.in.consultant.request.CreateConsultantRequest;
import org.grp2.api.trademe.adapter.in.consultant.response.CreateConsultantResponse;
import org.grp2.api.trademe.adapter.in.consultant.response.FindByIdConsultantResponse;
import org.grp2.api.trademe.application.port.in.command.CreateConsultantCommand;
import org.grp2.api.trademe.application.port.in.command.FindByIdConsultantCommand;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.CommandBus;
import org.grp2.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/consultant")
public final class ConsultantController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private ConsultantController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateConsultantResponse create(@RequestBody @Valid CreateConsultantRequest createConsultantRequest) {
        var accountId = (String) commandBus.post(new CreateConsultantCommand(createConsultantRequest.getEmail(),
                createConsultantRequest.getPassword(),
                createConsultantRequest.getName(),
                createConsultantRequest.getLastName()));
        return new CreateConsultantResponse(accountId);
    }

    @GetMapping("/get/{id}")
    public FindByIdConsultantResponse getUser(@PathVariable("id") String id) {
        var consultant = (Consultant) commandBus.post(new FindByIdConsultantCommand(id));
        return new FindByIdConsultantResponse(
                consultant.id().value(),
                consultant.getAdr(),
                consultant.getAvailability(),
                consultant.getModality(),
                consultant.getEmail(),
                consultant.getName(),
                consultant.getLastName(),
                consultant.getSkills());
    }
}
