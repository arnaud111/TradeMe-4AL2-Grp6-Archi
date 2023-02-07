package org.grp2.api.trademe;

import org.grp2.api.trademe.application.events.account.client.ClientCreatedApplicationEvent;
import org.grp2.api.trademe.application.events.account.client.ClientCreatedEventHandler;
import org.grp2.api.trademe.application.events.account.consultant.ConsultantCreatedApplicationEvent;
import org.grp2.api.trademe.application.events.account.consultant.ConsultantCreatedEventHandler;
import org.grp2.api.trademe.application.events.account.consultant.ConsultantUpdatedApplicationEvent;
import org.grp2.api.trademe.application.events.account.consultant.ConsultantUpdatedEventHandler;
import org.grp2.api.trademe.application.events.offer.OfferCreatedApplicationEvent;
import org.grp2.api.trademe.application.events.offer.OfferCreatedEventHandler;
import org.grp2.api.trademe.application.port.in.command.account.client.CreateClientCommand;
import org.grp2.api.trademe.application.port.in.command.account.client.FindAllClientCommand;
import org.grp2.api.trademe.application.port.in.command.account.client.FindByIdClientCommand;
import org.grp2.api.trademe.application.port.in.command.account.consultant.*;
import org.grp2.api.trademe.application.port.in.command.offer.CreateOfferCommand;
import org.grp2.api.trademe.application.port.in.command.offer.FindAllOfferCommand;
import org.grp2.api.trademe.application.port.in.command.offer.FindByIdOfferCommand;
import org.grp2.api.trademe.application.services.account.client.CreateClientService;
import org.grp2.api.trademe.application.services.account.client.FindAllClientService;
import org.grp2.api.trademe.application.services.account.client.FindByIdClientService;
import org.grp2.api.trademe.application.services.account.consultant.*;
import org.grp2.api.trademe.application.services.offer.CreateOfferService;
import org.grp2.api.trademe.application.services.offer.FindAllOfferService;
import org.grp2.api.trademe.application.services.offer.FindByIdOfferService;
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
    private final FindAllConsultantService findAllConsultantService;
    private final FindAllMatchConsultantService findAllMatchConsultantService;
    private final UpdateConsultantService updateConsultantService;
    private final CreateClientService createClientService;
    private final FindByIdClientService findByIdClientService;
    private final FindAllClientService findAllClientService;
    private final CreateOfferService createOfferService;
    private final FindByIdOfferService findByIdOfferService;
    private final FindAllOfferService findAllOfferService;
    private final EventDispatcher eventDispatcher;
    private final ConsultantCreatedEventHandler consultantCreatedEventHandler;
    private final ConsultantUpdatedEventHandler consultantUpdatedEventHandler;
    private final ClientCreatedEventHandler clientCreatedEventHandler;
    private final OfferCreatedEventHandler offerCreatedEventHandler;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, CreateConsultantService createConsultantService, FindByIdConsultantService findByIdConsultantService, FindAllConsultantService findAllConsultantService, FindAllMatchConsultantService findAllMatchConsultantService, UpdateConsultantService updateConsultantService, CreateClientService createClientService, FindByIdClientService findByIdClientService, FindAllClientService findAllClientService, CreateOfferService createOfferService, FindByIdOfferService findByIdOfferService, FindAllOfferService findAllOfferService, EventDispatcher eventDispatcher, ConsultantCreatedEventHandler consultantCreatedEventHandler, ConsultantUpdatedEventHandler consultantUpdatedEventHandler, ClientCreatedEventHandler clientCreatedEventHandler, OfferCreatedEventHandler offerCreatedEventHandler) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.createConsultantService = createConsultantService;
        this.findByIdConsultantService = findByIdConsultantService;
        this.findAllConsultantService = findAllConsultantService;
        this.findAllMatchConsultantService = findAllMatchConsultantService;
        this.updateConsultantService = updateConsultantService;
        this.createClientService = createClientService;
        this.findByIdClientService = findByIdClientService;
        this.findAllClientService = findAllClientService;
        this.createOfferService = createOfferService;
        this.findByIdOfferService = findByIdOfferService;
        this.findAllOfferService = findAllOfferService;
        this.eventDispatcher = eventDispatcher;
        this.consultantCreatedEventHandler = consultantCreatedEventHandler;
        this.consultantUpdatedEventHandler = consultantUpdatedEventHandler;
        this.clientCreatedEventHandler = clientCreatedEventHandler;
        this.offerCreatedEventHandler = offerCreatedEventHandler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        eventDispatcher.register(ConsultantCreatedApplicationEvent.class, consultantCreatedEventHandler);

        eventDispatcher.register(ConsultantUpdatedApplicationEvent.class, consultantUpdatedEventHandler);

        eventDispatcher.register(ClientCreatedApplicationEvent.class, clientCreatedEventHandler);

        eventDispatcher.register(OfferCreatedApplicationEvent.class, offerCreatedEventHandler);

        commandBus.register(CreateConsultantCommand.class, createConsultantService);

        commandBus.register(FindByIdConsultantCommand.class, findByIdConsultantService);

        commandBus.register(FindAllConsultantCommand.class, findAllConsultantService);

        commandBus.register(FindAllMatchConsultantCommand.class, findAllMatchConsultantService);

        commandBus.register(UpdateConsultantCommand.class, updateConsultantService);

        commandBus.register(CreateClientCommand.class, createClientService);

        commandBus.register(FindByIdClientCommand.class, findByIdClientService);

        commandBus.register(FindAllClientCommand.class, findAllClientService);

        commandBus.register(CreateOfferCommand.class, createOfferService);

        commandBus.register(FindByIdOfferCommand.class, findByIdOfferService);

        commandBus.register(FindAllOfferCommand.class, findAllOfferService);
    }
}
