package com.vanderkast.blog_server.database.repository;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimplePublicationRepository
        extends CrudRepository<SimplePublication, String> {
}
