package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.model.Publication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SimplePublicationTransactionImplTest {
    private SimplePublicationTransaction transaction;

    private static SimplePublication simplePublication;

    @TestConfiguration
    static class Config {
        @Bean
        SimplePublicationTransaction beanSimplePublicationTransaction() {
            return new SimplePublicationTransactionImpl();
        }
    }

    @Before
    public void setUp() {
        simplePublication = new SimplePublication();
        simplePublication.setTitle("test title");
        simplePublication.setContent("test content");
        simplePublication.setTimestamp(new Date().getTime());
    }

    @Autowired
    public void setTransaction(SimplePublicationTransaction transaction) {
        this.transaction = transaction;
    }

    @Test
    public void complete() {
        String id = transaction.create(simplePublication);
        assert id != null;
        SimplePublication test = transaction.getById(id);
        assert test != null;
        assert test.getTitle().equals(test.getTitle());
        assert test.getContent().equals(test.getContent());
        assert test.getTimestamp().equals(test.getTimestamp());
    }
}
