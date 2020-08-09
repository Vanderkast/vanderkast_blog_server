package com.vanderkast.blog_server.helper;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.mock.MockSimplePublication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MockSimplePublicationRepositoryTest {
    private MockSimplePublicationRepository repository;

    @Before
    public void setUp() {
        repository = new MockSimplePublicationRepository();
    }

    void assertContentEquals(SimplePublication a, SimplePublication b) {
        assertEquals(a.getTitle(), b.getTitle());
        assertEquals(a.getContent(), b.getContent());
    }

    @Test
    public void save() {
        SimplePublication mock = MockSimplePublication.get();
        SimplePublication saved = repository.save(mock);
        assertContentEquals(mock, saved);
    }

    @Test
    public void saveAll() {
        List<SimplePublication> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(MockSimplePublication.get());
        }
        Iterator<SimplePublication> saved = repository.saveAll(list).iterator();
        for (int i = 0; i < 10; i++) {
            assertContentEquals(list.get(i), saved.next());
        }
    }

    @Test
    public void findById() {
        SimplePublication mock = MockSimplePublication.get();
        String id = repository.save(mock).getId();
        SimplePublication found = repository.findById(id).orElseThrow();
        assertContentEquals(mock, found);
    }

    @Test
    public void existsById() {
        SimplePublication mock = MockSimplePublication.get();
        String id = repository.save(mock).getId();
        assertTrue(repository.findById(id).isPresent());
    }

    @Test
    public void findAll() {
    }
}
