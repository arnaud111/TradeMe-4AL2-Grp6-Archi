package org.grp2.api.trademe.adapter.in.consultant;

import org.grp2.api.trademe.adapter.in.consultant.request.CreateConsultantRequest;
import org.grp2.api.trademe.adapter.in.consultant.response.CreateConsultantResponse;
import org.grp2.api.trademe.application.port.in.CreateConsultantCommand;
import org.grp2.kernel.CommandBus;
import org.grp2.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateConsultantResponse create(@RequestBody @Valid CreateConsultantRequest createConsultantRequest) {
        var userId = (String) commandBus.post(new CreateConsultantCommand());
        return new CreateConsultantResponse(userId);
    }
}
