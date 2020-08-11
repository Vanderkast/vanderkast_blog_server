package com.vanderkast.blog_server.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.mock.MockSimplePublication;
import com.vanderkast.blog_server.model.Publication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PublicationSerializationTest {
    final ObjectMapper mapper = new HelpersConfig().beanObjectMapper();

    @Test
    public void simpleSerialization() throws JsonProcessingException {
        var simple = new SimplePublication();
        var json = mapper.writeValueAsString(simple);
        assertTrue(json.contains("type"));
        assertTrue(json.contains(simple.getType()));
    }

    @Test
    public void emptySimpleDeserialization() throws JsonProcessingException {
        var simple = new SimplePublication();
        var json = mapper.writeValueAsString(simple);
        var publication = mapper.readValue(json, Publication.class);
        assertEquals(publication.getType(), simple.getType());
    }

    @Test
    public void filledSimpleDeserialization() throws JsonProcessingException {
        var simple = MockSimplePublication.get();
        var json = mapper.writeValueAsString(simple);
        var publication = mapper.readValue(json, Publication.class);
        assertEquals(publication.getType(), simple.getType());
        SimplePublication result = (SimplePublication) publication;
        assertEquals(result.getId(), result.getId());
        assertEquals(result.getTitle(), result.getTitle());
        assertEquals(result.getContent(), result.getContent());
        assertEquals(result.getTimestamp(), result.getTimestamp());
    }
}
