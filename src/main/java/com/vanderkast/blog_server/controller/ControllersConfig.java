package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.controller.saving_controllers.SavingController;
import com.vanderkast.blog_server.controller.saving_controllers.SimpleSavingController;
import com.vanderkast.blog_server.database.transaction.DeleteTransaction;
import com.vanderkast.blog_server.database.transaction.ReadTransaction;
import com.vanderkast.blog_server.database.transaction.SavePublicationTransaction;
import com.vanderkast.blog_server.domain.SimplePublication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("release")
public class ControllersConfig {
    @Bean
    ControllersFacade beanControllersFacade(ControllersProvider provider, ReadController readController) {
        return new ControllersFacadeImpl(provider, readController);
    }

    @Bean
    ControllersProvider beanControllersProvider() {
        return new ControllersProvider();
    }

    @Bean
    DeletionController beanDeletionController(DeleteTransaction deleteTransaction) {
        return new DeletionControllerImpl(deleteTransaction);
    }

    @Bean
    SavingController<SimplePublication> beanSavingController(SavePublicationTransaction<SimplePublication> savePublicationTransaction) {
        return new SimpleSavingController(savePublicationTransaction);
    }

    @Bean
    ReadController beanReadController(ReadTransaction readTransaction) {return new ReadControllerImpl(readTransaction);}
}
