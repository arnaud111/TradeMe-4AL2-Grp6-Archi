package org.grp2.api.trademe;

import org.grp2.api.trademe.application.events.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.events.ConsultantCreatedEventHandler;
import org.grp2.api.trademe.application.port.in.CreateConsultantCommand;
import org.grp2.api.trademe.application.services.CreateConsultantService;
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
    private final EventDispatcher eventDispatcher;
    private final ConsultantCreatedEventHandler consultantCreatedEventHandler;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, CreateConsultantService createConsultantService, EventDispatcher eventDispatcher, ConsultantCreatedEventHandler consultantCreatedEventHandler) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.createConsultantService = createConsultantService;
        this.eventDispatcher = eventDispatcher;
        this.consultantCreatedEventHandler = consultantCreatedEventHandler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        eventDispatcher.register(ConsultantCreatedApplicationEvent.class, consultantCreatedEventHandler);

        commandBus.register(CreateConsultantCommand.class, createConsultantService);
    }
}
