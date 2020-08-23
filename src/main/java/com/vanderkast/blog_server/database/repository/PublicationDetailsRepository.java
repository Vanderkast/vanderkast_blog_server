package com.vanderkast.blog_server.database.repository;

import com.vanderkast.blog_server.database.dao.PublicationDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PublicationDetailsRepository extends CrudRepository<PublicationDetails, String> {
    @Modifying
    @Transactional
    @Query("select pd from PublicationDetails pd order by pd.publication.timestamp desc")
    List<PublicationDetails> readAllOrderedByTimestamp();
}
