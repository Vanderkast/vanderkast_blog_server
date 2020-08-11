package com.vanderkast.blog_server.model;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class PublicationTest {
    @Test
    public void simple() {
        var simple = new SimplePublication();
        assertEquals(simple.getClass().getSimpleName(), simple.getType());
    }
}
