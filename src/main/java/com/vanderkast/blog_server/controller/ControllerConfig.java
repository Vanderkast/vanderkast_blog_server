package com.vanderkast.blog_server.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(lazyInit = true)
public class ControllerConfig {
    @Bean
    SimplePublicationController beanSimplePublicationController() {return new SimplePublicationController();}
}
