package com.vanderkast.blog_server.database.repository;

import com.vanderkast.blog_server.mock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class PublicationDetailsRepositoryJpaDatabaseTest {

    @Autowired
    private PublicationDetailsRepository repository;

    @Test
    public void readAllOrderedByTimestamp() {
        var pe = Mock.getPublicationEntity(null);
        pe.setTimestamp(new Date().getTime() + 100000);
        var details1 = Mock.getPublicationDetails((String) null);
        details1.setPublication(pe);

        var details2 = Mock.getPublicationDetails((String) null);

        repository.save(details2);
        repository.save(details1);

        var list = repository.readAllOrderedByTimestamp();

        assertNotNull(list);
        assertEquals(pe.getTimestamp(), list.get(0).getPublication().getTimestamp());
    }
}


