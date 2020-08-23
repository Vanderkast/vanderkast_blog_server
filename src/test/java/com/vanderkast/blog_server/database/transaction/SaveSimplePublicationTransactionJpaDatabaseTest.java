package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.repository.PublicationDetailsRepository;
import com.vanderkast.blog_server.domain.SimplePublication;
import com.vanderkast.blog_server.mock.Mock;
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
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class SaveSimplePublicationTransactionJpaDatabaseTest {
    @Autowired
    private SavePublicationTransaction<SimplePublication> transaction;

    @Autowired
    private PublicationDetailsRepository repository;

    @TestConfiguration
    @Profile("test")
    static abstract class Config {
        @Bean
        SavePublicationTransaction<SimplePublication> beanSavePublicationTransaction(PublicationDetailsRepository repository) {
            return new SaveSimplePublicationTransaction(repository);
        }
    }

    @Test
    public void save() {
        String id = transaction.save(Mock.getSimplePublication(null));
        assertNotNull(id);
        assertEquals(1, repository.count());
    }
}
