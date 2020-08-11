package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.model.Publication;

import java.util.List;

public interface SimplePublicationTransaction {
    List<SimplePublication> getAll();

    String create(SimplePublication publication);

    SimplePublication getById(String id);

    void deleteById(String id);
}
