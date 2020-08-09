package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.database.repository.SimplePublicationRepository;
import com.vanderkast.blog_server.database.transaction.SimplePublicationTransaction;
import com.vanderkast.blog_server.database.transaction.SimplePublicationTransactionImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PublicationControllerTest {
    @Autowired
    private ControllersProvider controllersProvider;

    @TestConfiguration
    @Profile("test")
    static class Config {
        @Bean
        SimplePublicationController beanSimplePublicationController() {
            return new SimplePublicationController();
        }

        @Bean
        ControllersProvider beanControllersProvider() {
            return new ControllersProvider();
        }

        @Bean
        SimplePublicationTransaction beanSimplePublicationTransaction() {
            return new SimplePublicationTransactionImpl();
        }
    }

    @Test
    public void getInstance() {
        PublicationController<SimplePublication> controller = controllersProvider.getInstance(SimplePublication.class);
        assertNotNull(controller);
        assertEquals(controller.getClass(), SimplePublicationController.class);
    }
}


