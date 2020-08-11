package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.controller.get.GrandController;
import com.vanderkast.blog_server.controller.get.GrandControllerImpl;
import com.vanderkast.blog_server.database.transaction.SimplePublicationTransaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("release")
public class ControllerConfig {
    @Bean
    SimplePublicationController beanSimplePublicationController() {
        return new SimplePublicationController();
    }

    @Bean
    ControllersProvider beanControllersProvider() {
        return new ControllersProvider();
    }

    @Bean
    GrandController beanGetAllController(SimplePublicationTransaction transaction) {
        return new GrandControllerImpl(transaction);
    }
}
