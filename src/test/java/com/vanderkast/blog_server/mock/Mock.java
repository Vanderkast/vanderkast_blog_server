package com.vanderkast.blog_server.mock;

import com.vanderkast.blog_server.database.dao.PublicationDetails;
import com.vanderkast.blog_server.database.dao.PublicationEntity;
import com.vanderkast.blog_server.domain.Publication;
import com.vanderkast.blog_server.domain.SimplePublication;
import com.vanderkast.blog_server.rest.model.CompositePublication;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.UUID;

public interface Mock {
    static PublicationDetails getPublicationDetails(PublicationEntity entity) {
        PublicationDetails details = new PublicationDetails();
        details.setPublication(entity);
        details.setId(entity.getId());
        details.setTitle("mock title");
        details.setContent("mock content");
        return details;
    }

    static PublicationDetails getPublicationDetails(@Nullable String id) {
        var entity = getPublicationEntity(id);
        return getPublicationDetails(entity);
    }

    static PublicationDetails getPublicationDetails() {
        var entity = getPublicationEntity();
        return getPublicationDetails(entity);
    }

    static PublicationEntity getPublicationEntity(@Nullable String id) {
        return new PublicationEntity(id, new Date().getTime(), Publication.Type.SIMPLE);
    }

    static PublicationEntity getPublicationEntity() {
        return getPublicationEntity(UUID.randomUUID().toString());
    }

    static SimplePublication getSimplePublication(String id) {
        return new SimplePublication(id, new Date().getTime(), "mock title", "mock content");
    }

    static CompositePublication getCompositeSimplePublication(String id, Publication.Type type) {
        return new CompositePublication(id, type, new Date().getTime(), "mock title", "mock content");
    }
}
