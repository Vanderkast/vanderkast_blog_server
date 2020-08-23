package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.dao.PublicationDetails;
import com.vanderkast.blog_server.database.dao.PublicationEntity;
import com.vanderkast.blog_server.database.repository.PublicationDetailsRepository;
import com.vanderkast.blog_server.domain.SimplePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSimplePublicationTransaction implements SavePublicationTransaction<SimplePublication> {
    private final PublicationDetailsRepository repository;

    @Autowired
    public SaveSimplePublicationTransaction(PublicationDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public String save(SimplePublication publication) {
        return repository.save(convert(publication)).getId();
    }

    private PublicationDetails convert(SimplePublication publication) {
        var data = new PublicationDetails();
        data.setId(publication.getId());
        data.setTitle(publication.getTitle());
        data.setContent(publication.getContent());
        data.setPublication(new PublicationEntity(publication.getId(),
                publication.getTimestamp(), publication.getType()));
        return data;
    }
}
