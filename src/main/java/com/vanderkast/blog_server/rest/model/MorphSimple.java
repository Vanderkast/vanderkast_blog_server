package com.vanderkast.blog_server.rest.model;

import com.vanderkast.blog_server.domain.SimplePublication;

public class MorphSimple implements Morph<SimplePublication> {
    @Override
    public SimplePublication handle(CompositePublication composite) {
        return new SimplePublication(composite.getId(),
                composite.getTimestamp(),
                composite.getTitle(),
                composite.getContent());
    }

    @Override
    public CompositePublication handle(SimplePublication publication) {
        return new CompositePublication(publication.getId(),
                publication.getType(),
                publication.getTimestamp(),
                publication.getTitle(),
                publication.getContent());
    }
}
