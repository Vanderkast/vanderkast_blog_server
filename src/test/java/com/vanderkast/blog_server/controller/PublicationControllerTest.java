package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PublicationControllerTest {

    @TestConfiguration
    static class Config {
        @Bean
        SimplePublicationController beanSimplePublicationController() {
            return new SimplePublicationController();
        }
    }

    @Test
    public void getInstance() {
        PublicationController<SimplePublication> controller = PublicationController.getInstance(SimplePublication.class);
        assert controller != null;
        assert controller instanceof SimplePublicationController;
    }
}
