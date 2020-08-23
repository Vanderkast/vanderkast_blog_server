package com.vanderkast.blog_server.database.repository;

import com.vanderkast.blog_server.database.dao.PublicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends CrudRepository<PublicationEntity, String> {
}
