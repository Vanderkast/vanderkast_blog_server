package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.domain.Publication;

public interface SavePublicationTransaction<P extends Publication> {
    String save(P publication);
}
