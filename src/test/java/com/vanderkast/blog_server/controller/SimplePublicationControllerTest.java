package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.database.transaction.SimplePublicationTransaction;
import com.vanderkast.blog_server.database.transaction.SimplePublicationTransactionImpl;
import com.vanderkast.blog_server.mock.MockSimplePublication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class SimplePublicationControllerTest {
    @Autowired
    SimplePublicationTransaction simplePublicationTransaction;

    private SimplePublicationController controller;

    @Before
    public void setUp() {
        controller = new SimplePublicationController();
    }

    @TestConfiguration
    @Profile("test")
    public static class Config {
        @Bean
        SimplePublicationTransaction beanSimplePublicationTransaction() {
            return new SimplePublicationTransactionImpl();
        }
    }
    
    @Test
    public void createSimple() {
        controller.setTransaction(simplePublicationTransaction);

        SimplePublication publication = MockSimplePublication.get();
        String createdId = controller.create(publication);
        assertNotNull(createdId);
        assertFalse(createdId.isEmpty());
    }
}
