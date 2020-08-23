package com.vanderkast.blog_server.mock;

import com.vanderkast.blog_server.database.dao.PublicationDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MappedRepositoryTest {
    private MappedRepository<PublicationDetails> repo;

    @Before
    public void setUp() {
        repo = new MappedRepository<>(
                new MappedRepository.IdProvider<>() {
                    @Override
                    public String create(PublicationDetails publicationDetails) {
                        var id = UUID.randomUUID().toString();
                        publicationDetails.setId(id);
                        return id;
                    }

                    @Override
                    public Optional<String> check(PublicationDetails publicationDetails) {
                        return Optional.ofNullable(publicationDetails.getId());
                    }
                });
    }

    @Test
    public void saveWithId() {
        var entity = Mock.getPublicationDetails();
        var test = repo.save(entity);
        assertNull(test);
        assertEquals(0, repo.data.size());
    }

    @Test
    public void saveWithoutId() {
        var entity = Mock.getPublicationDetails((String) null);
        var test = repo.save(entity);
        assertNotNull(test);
        assertEquals(1, repo.data.size());
    }

    @Test
    public void testEdit() {
        var entity = Mock.getPublicationDetails((String) null);
        var id = repo.save(entity).getId();
        assertNotNull(id);

        final String editedContent = "new content";
        entity.setContent(editedContent);
        repo.save(entity);

        var found = repo.findById(id);
        assertTrue(found.isPresent());
        assertEquals(editedContent, found.get().getContent());
    }

    @Test
    public void saveAll() {
        var first = Mock.getPublicationDetails();
        var second = Mock.getPublicationDetails();
        repo.saveAll(Arrays.asList(first, second));
        assertEquals(0, repo.data.size());
    }

    @Test
    public void saveAllWithoutId() {
        var first = Mock.getPublicationDetails((String) null);
        var second = Mock.getPublicationDetails((String) null);
        repo.saveAll(Arrays.asList(first, second));
        assertEquals(2, repo.data.size());
    }

    @Test
    public void findById() {
        var entity = Mock.getPublicationDetails((String) null);
        var id = repo.save(entity).getId();
        assertNotNull(id);
        var found = repo.findById(id);
        assertNotNull(found);
        assertTrue(found.isPresent());
        assertEquals(entity.getId(), found.get().getId());
    }

    @Test
    public void existsById() {
        var entity = Mock.getPublicationDetails((String) null);
        repo.save(entity);
        assertTrue(repo.existsById(entity.getId()));
    }

    @Test
    public void count() {
        var first = Mock.getPublicationDetails((String) null);
        var second = Mock.getPublicationDetails((String) null);
        repo.saveAll(Arrays.asList(first, second));
        assertEquals(2, repo.count());
    }

    @Test
    public void deleteById() {
        var entity = Mock.getPublicationDetails((String) null);
        var id = repo.save(entity).getId();
        assertEquals(1, repo.count());
        repo.deleteById(id);
        assertFalse(repo.existsById(id));
        assertEquals(0, repo.count());
    }

    @Test
    public void delete() {
        var entity = Mock.getPublicationDetails((String) null);
        var id = repo.save(entity).getId();
        assertEquals(1, repo.count());
        repo.delete(entity);
        assertFalse(repo.existsById(id));
        assertEquals(0, repo.count());
    }

    @Test
    public void deleteAll() {
        var first = Mock.getPublicationDetails((String) null);
        var second = Mock.getPublicationDetails((String) null);
        repo.saveAll(Arrays.asList(first, second));
        assertEquals(2, repo.count());
        repo.deleteAll();
        assertEquals(0, repo.count());
    }
}
