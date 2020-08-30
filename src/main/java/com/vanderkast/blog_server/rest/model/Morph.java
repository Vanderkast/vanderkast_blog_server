package com.vanderkast.blog_server.rest.model;

import com.vanderkast.blog_server.domain.Publication;

@SuppressWarnings("unchecked")
public interface Morph<P extends Publication> {

    static <P extends Publication>  Morph<P> getInstance(String type) {
        return getInstance(Publication.Type.valueOf(type));
    }

    static <P extends Publication> Morph<P> getInstance(Publication.Type type) {
        if (type == Publication.Type.SIMPLE)
            return (Morph<P>) new MorphSimple();
        return null;
    }

    P handle(CompositePublication composite);

    CompositePublication handle(P publication);
}
