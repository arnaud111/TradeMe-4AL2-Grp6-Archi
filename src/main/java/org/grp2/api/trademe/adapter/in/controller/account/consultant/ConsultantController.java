package org.grp2.api.trademe.adapter.in.controller.account.consultant;

import org.grp2.api.trademe.adapter.in.controller.account.consultant.request.CreateConsultantRequest;
import org.grp2.api.trademe.adapter.in.controller.account.consultant.request.UpdateConsultantRequest;
import org.grp2.api.trademe.adapter.in.controller.account.consultant.response.CreateConsultantResponse;
import org.grp2.api.trademe.adapter.in.controller.account.consultant.response.ConsultantResponse;
import org.grp2.api.trademe.adapter.in.mapper.ConsultantApiMapper;
import org.grp2.api.trademe.application.port.in.command.account.consultant.*;
import org.grp2.api.trademe.domain.dto.account.consultant.Consultant;
import org.grp2.kernel.CommandBus;
import org.grp2.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
                createConsultantRequest.getLastName(),
                createConsultantRequest.getAdr(),
                createConsultantRequest.getAvailability(),
                createConsultantRequest.getModality(),
                createConsultantRequest.getSkills()));
        return new CreateConsultantResponse(accountId);
    }

    @GetMapping("/get/{id}")
    public ConsultantResponse getById(@PathVariable("id") String id) {
        var consultant = (Consultant) commandBus.post(new FindByIdConsultantCommand(id));
        return ConsultantApiMapper.consultantToConsultantResponse(consultant);
    }

    @GetMapping("/get")
    public List<ConsultantResponse> getAll() {
        var consultants = (List<Consultant>) commandBus.post(new FindAllConsultantCommand());
        return ConsultantApiMapper.consultantsToConsultantResponses(consultants);
    }

    @GetMapping("/find")
    public List<ConsultantResponse> find(@RequestParam(required=false) String name, @RequestParam(required=false) String lastName, @RequestParam(required=false) Integer adrMin, @RequestParam(required=false) Integer adrMax) {
        var consultants = (List<Consultant>) commandBus.post(new FindAllMatchConsultantCommand(
                name,
                lastName,
                adrMin,
                adrMax
        ));
        return ConsultantApiMapper.consultantsToConsultantResponses(consultants);
    }

    @PostMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ConsultantResponse update(@RequestBody UpdateConsultantRequest updateConsultantRequest, @PathVariable("id") String id) {
        var consultant = (Consultant) commandBus.post(new UpdateConsultantCommand(
                id,
                updateConsultantRequest.getName(),
                updateConsultantRequest.getLastName(),
                updateConsultantRequest.getAdr(),
                updateConsultantRequest.getAvailability(),
                updateConsultantRequest.getModality(),
                updateConsultantRequest.getSkills()
        ));
        return ConsultantApiMapper.consultantToConsultantResponse(consultant);
    }

    @PostMapping(value = "/addSkill/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ConsultantResponse addSkill(@RequestBody String skill, @PathVariable("id") String id) {
        var consultant = (Consultant) commandBus.post(new AddSkillConsultantCommand(id, skill));
        return ConsultantApiMapper.consultantToConsultantResponse(consultant);
    }

    @PostMapping(value = "/removeSkill/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ConsultantResponse removeSkill(@RequestBody String skill, @PathVariable("id") String id) {
        var consultant = (Consultant) commandBus.post(new AddSkillConsultantCommand(id, skill));
        return ConsultantApiMapper.consultantToConsultantResponse(consultant);
    }
}
