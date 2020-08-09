package com.vanderkast.blog_server.mock;

import com.vanderkast.blog_server.database.dto.SimplePublication;

import java.util.Date;

public class MockSimplePublication {
    public static SimplePublication get() {
        SimplePublication simplePublication = new SimplePublication();
        simplePublication.setTitle("mock title");
        simplePublication.setContent("mock content");
        simplePublication.setTimestamp(new Date().getTime());
        return simplePublication;
    }
}
