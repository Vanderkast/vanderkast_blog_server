package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.repository.PublicationDetailsRepository;
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

import static org.junit.Assert.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class DeleteTransactionImplJpaDatabaseTest {
    @Autowired
    private DeleteTransaction transaction;

    @Autowired
    private PublicationDetailsRepository repository;

    @TestConfiguration
    @Profile("test")
    static class Config {
        @Bean
        DeleteTransaction beanDeleteTransaction(PublicationDetailsRepository repo) {return new DeleteTransactionImpl(repo);}
    }

    @Test
    public void delete() {
        var id = repository.save(Mock.getPublicationDetails((String) null)).getId();
        assertNotNull(id);
        transaction.delete(id);
        assertEquals(0, repository.count());
    }
}
