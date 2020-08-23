package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.domain.Publication;

import java.util.List;

public interface ReadTransaction {
    List<Publication> readAll();
}
