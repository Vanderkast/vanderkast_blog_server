package com.vanderkast.blog_server.controller;

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
}
