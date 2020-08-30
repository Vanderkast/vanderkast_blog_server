package com.vanderkast.blog_server.rest.model;

import com.vanderkast.blog_server.domain.Publication;
import com.vanderkast.blog_server.domain.SimplePublication;

public class MorphKeeper implements Morph<Publication> {
    private final Morph<SimplePublication> simple;

    public MorphKeeper(Morph<SimplePublication> simple) {
        this.simple = simple;
    }

    @Override
    public Publication handle(CompositePublication composite) {
        if (composite.getType().equals(Publication.Type.SIMPLE))
            return simple.handle(composite);
        return null;
    }

    @Override
    public CompositePublication handle(Publication publication) {
        if (publication.getType() == Publication.Type.SIMPLE)
            return simple.handle((SimplePublication) publication);
        return null;
    }

}
