package com.vanderkast.blog_server.rest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanderkast.blog_server.domain.Publication;
import com.vanderkast.blog_server.domain.SimplePublication;
import com.vanderkast.blog_server.mock.Mock;
import org.apache.tomcat.util.file.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CompositePublicationSerializationTest {

    @Test
    public void serializeSimple() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(Mock.getCompositeSimplePublication("id", Publication.Type.SIMPLE));
        assertTrue(json.contains("SIMPLE"));
    }

    @Test
    public void deserializeSimple() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(Mock.getCompositeSimplePublication("id", Publication.Type.SIMPLE));
        CompositePublication publication = mapper.readValue(json, CompositePublication.class);
        assertEquals(publication.getType(), Publication.Type.SIMPLE);
    }
}
