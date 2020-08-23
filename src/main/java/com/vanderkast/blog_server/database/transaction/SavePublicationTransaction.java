package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.domain.Publication;

public interface SavePublicationTransaction<Pub extends Publication> {
    String save(Pub publication);
}
