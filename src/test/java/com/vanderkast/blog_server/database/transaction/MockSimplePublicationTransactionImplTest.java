package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.dto.SimplePublication;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MockSimplePublicationTransactionImplTest {
    private SimplePublicationTransaction transaction;

    private SimplePublication mock;

    @TestConfiguration
    @Profile("test")
    static class Config {
        @Bean
        SimplePublicationTransaction beanSimplePublicationTransaction() {
            return new SimplePublicationTransactionImpl();
        }
    }

    @Before
    public void setUp() {
        mock = MockSimplePublication.get();
    }

    @Autowired
    public void setTransaction(SimplePublicationTransaction transaction) {
        this.transaction = transaction;
    }

    @Test
    public void complete() {
        String id = transaction.create(mock);
        assertNotNull(id);
        SimplePublication test = transaction.getById(id);
        assertNotNull(test);
        assertEquals(mock.getTitle(), test.getTitle());
        assertEquals(mock.getContent(),test.getContent());
        assertEquals(mock.getTimestamp(), test.getTimestamp());
    }
}


