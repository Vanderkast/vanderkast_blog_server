package com.vanderkast.blog_server.rest.model;

import com.vanderkast.blog_server.domain.Publication;

public interface Morph<Pub extends Publication> {

    static Morph<?> getInstance(String type) {
        return getInstance(Publication.Type.valueOf(type));
    }

    static Morph<?> getInstance(Publication.Type type) {
        switch (type) {
            case SIMPLE:
                return new MorphSimple();
            default:
                return null;
        }
    }

    Pub handle(CompositePublication composite);

    CompositePublication handle(Pub publication);
}
