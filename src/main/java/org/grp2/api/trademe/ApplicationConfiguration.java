package org.grp2.api.trademe;

import org.grp2.api.trademe.adapter.out.persistence.ClientPersistenceAdapter;
import org.grp2.api.trademe.adapter.out.persistence.OfferPersistenceAdapter;
import org.grp2.api.trademe.adapter.out.repository.ClientEntityRepository;
import org.grp2.api.trademe.adapter.out.repository.ConsultantEntityRepository;
import org.grp2.api.trademe.adapter.out.persistence.ConsultantPersistenceAdapter;
import org.grp2.api.trademe.adapter.out.LogNotifications;
import org.grp2.api.trademe.adapter.out.repository.OfferEntityRepository;
import org.grp2.api.trademe.application.events.account.client.ClientCreatedEventHandler;
import org.grp2.api.trademe.application.events.account.consultant.ConsultantCreatedEventHandler;
import org.grp2.api.trademe.application.events.account.consultant.ConsultantUpdatedEventHandler;
import org.grp2.api.trademe.application.events.offer.OfferCreatedEventHandler;
import org.grp2.api.trademe.application.services.account.client.CreateClientService;
import org.grp2.api.trademe.application.services.account.client.FindAllClientService;
import org.grp2.api.trademe.application.services.account.client.FindByIdClientService;
import org.grp2.api.trademe.application.services.account.consultant.*;
import org.grp2.api.trademe.application.services.offer.CreateOfferService;
import org.grp2.api.trademe.application.services.offer.FindAllOfferService;
import org.grp2.api.trademe.application.services.offer.FindByIdOfferService;
import org.grp2.kernel.EventDispatcher;
import org.grp2.kernel.KernelConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(KernelConfiguration.class)
public class ApplicationConfiguration {

    @Autowired
    private ConsultantEntityRepository consultantEntityRepository;

    @Autowired
    private ClientEntityRepository clientEntityRepository;

    @Autowired
    private OfferEntityRepository offerEntityRepository;

    @Autowired
    private EventDispatcher eventDispatcher;

    @Bean
    public ConsultantPersistenceAdapter consultantPersistenceAdapter() {
        return new ConsultantPersistenceAdapter(consultantEntityRepository);
    }

    @Bean
    public ClientPersistenceAdapter clientPersistenceAdapter() {
        return new ClientPersistenceAdapter(clientEntityRepository);
    }

    @Bean
    public OfferPersistenceAdapter offerPersistenceAdapter() {
        return new OfferPersistenceAdapter(offerEntityRepository);
    }

    @Bean
    public CreateConsultantService createConsultantService() {
        return new CreateConsultantService(consultantPersistenceAdapter(), eventDispatcher);
    }

    @Bean
    public FindByIdConsultantService findByIdConsultantService() {
        return new FindByIdConsultantService(consultantPersistenceAdapter());
    }

    @Bean
    public FindAllConsultantService findAllConsultantService() {
        return new FindAllConsultantService(consultantPersistenceAdapter());
    }

    @Bean
    public FindAllMatchConsultantService findAllMatchConsultantService() {
        return new FindAllMatchConsultantService(consultantPersistenceAdapter());
    }

    @Bean
    public UpdateConsultantService updateConsultantService() {
        return new UpdateConsultantService(consultantPersistenceAdapter(), consultantPersistenceAdapter(), eventDispatcher);
    }

    @Bean
    public AddSkillConsultantService addSkillConsultantService() {
        return new AddSkillConsultantService(consultantPersistenceAdapter(), consultantPersistenceAdapter(), eventDispatcher);
    }

    @Bean
    public RemoveSkillConsultantService removeSkillConsultantService() {
        return new RemoveSkillConsultantService(consultantPersistenceAdapter(), consultantPersistenceAdapter(), eventDispatcher);
    }

    @Bean
    public CreateClientService createClientService() {
        return new CreateClientService(clientPersistenceAdapter(), eventDispatcher);
    }

    @Bean
    public FindByIdClientService findByIdClientService() {
        return new FindByIdClientService(clientPersistenceAdapter());
    }

    @Bean
    public FindAllClientService findAllClientService() {
        return new FindAllClientService(clientPersistenceAdapter());
    }

    @Bean
    public CreateOfferService createOfferService() {
        return new CreateOfferService(offerPersistenceAdapter(), clientPersistenceAdapter(), eventDispatcher);
    }

    @Bean
    public FindByIdOfferService findByIdOfferService() {
        return new FindByIdOfferService(offerPersistenceAdapter());
    }

    @Bean
    public FindAllOfferService findAllOfferService() {
        return new FindAllOfferService(offerPersistenceAdapter());
    }

    @Bean
    public ConsultantCreatedEventHandler consultantCreatedEventHandler() {
        return new ConsultantCreatedEventHandler(new LogNotifications());
    }

    @Bean
    public ConsultantUpdatedEventHandler consultantUpdatedEventHandler() {
        return new ConsultantUpdatedEventHandler(new LogNotifications());
    }

    @Bean
    public ClientCreatedEventHandler clientCreatedEventHandler() {
        return new ClientCreatedEventHandler(new LogNotifications());
    }

    @Bean
    public OfferCreatedEventHandler offerCreatedEventHandler() {
        return new OfferCreatedEventHandler(new LogNotifications());
    }
}
