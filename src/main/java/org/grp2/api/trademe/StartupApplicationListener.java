package org.grp2.api.trademe;

import org.grp2.api.trademe.application.events.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.events.ConsultantCreatedEventHandler;
import org.grp2.api.trademe.application.events.ConsultantUpdatedApplicationEvent;
import org.grp2.api.trademe.application.events.ConsultantUpdatedEventHandler;
import org.grp2.api.trademe.application.port.in.command.consultant.CreateConsultantCommand;
import org.grp2.api.trademe.application.port.in.command.consultant.FindByIdConsultantCommand;
import org.grp2.api.trademe.application.port.in.command.consultant.UpdateConsultantCommand;
import org.grp2.api.trademe.application.services.consultant.CreateConsultantService;
import org.grp2.api.trademe.application.services.consultant.FindByIdConsultantService;
import org.grp2.api.trademe.application.services.consultant.UpdateConsultantService;
import org.grp2.kernel.CommandBus;
import org.grp2.kernel.EventDispatcher;
import org.grp2.kernel.QueryBus;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final CreateConsultantService createConsultantService;
    private final FindByIdConsultantService findByIdConsultantService;
    private final UpdateConsultantService updateConsultantService;
    private final EventDispatcher eventDispatcher;
    private final ConsultantCreatedEventHandler consultantCreatedEventHandler;
    private final ConsultantUpdatedEventHandler consultantUpdatedEventHandler;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, CreateConsultantService createConsultantService, FindByIdConsultantService findByIdConsultantService, UpdateConsultantService updateConsultantService, EventDispatcher eventDispatcher, ConsultantCreatedEventHandler consultantCreatedEventHandler, ConsultantUpdatedEventHandler consultantUpdatedEventHandler) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.createConsultantService = createConsultantService;
        this.findByIdConsultantService = findByIdConsultantService;
        this.updateConsultantService = updateConsultantService;
        this.eventDispatcher = eventDispatcher;
        this.consultantCreatedEventHandler = consultantCreatedEventHandler;
        this.consultantUpdatedEventHandler = consultantUpdatedEventHandler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        eventDispatcher.register(ConsultantCreatedApplicationEvent.class, consultantCreatedEventHandler);

        eventDispatcher.register(ConsultantUpdatedApplicationEvent.class, consultantUpdatedEventHandler);

        commandBus.register(CreateConsultantCommand.class, createConsultantService);

        commandBus.register(FindByIdConsultantCommand.class, findByIdConsultantService);

        commandBus.register(UpdateConsultantCommand.class, updateConsultantService);
    }
}
