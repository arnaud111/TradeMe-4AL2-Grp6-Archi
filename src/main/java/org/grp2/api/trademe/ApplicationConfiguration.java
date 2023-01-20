package org.grp2.api.trademe;

import org.grp2.api.trademe.adapter.out.repository.ConsultantEntityRepository;
import org.grp2.api.trademe.adapter.out.persistence.ConsultantPersistenceAdapter;
import org.grp2.api.trademe.adapter.out.LogNotifications;
import org.grp2.api.trademe.application.events.ConsultantCreatedEventHandler;
import org.grp2.api.trademe.application.services.CreateConsultantService;
import org.grp2.api.trademe.application.services.FindByIdConsultantService;
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
    private EventDispatcher eventDispatcher;

    @Bean
    public ConsultantPersistenceAdapter persistenceAdapter() {
        return new ConsultantPersistenceAdapter(consultantEntityRepository);
    }

    @Bean
    public CreateConsultantService createConsultantService() {
        return new CreateConsultantService(persistenceAdapter(), eventDispatcher);
    }

    @Bean
    public FindByIdConsultantService findByIdConsultantService() {
        return new FindByIdConsultantService(persistenceAdapter());
    }

    @Bean
    public ConsultantCreatedEventHandler consultantCreatedEventHandler() {
        return new ConsultantCreatedEventHandler(new LogNotifications());
    }
}
