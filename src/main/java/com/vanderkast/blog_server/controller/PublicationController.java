package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.model.Publication;

public interface PublicationController<P extends Publication> {
    ControllersProvider provider = new ControllersProvider();

    static <Pub extends Publication> PublicationController<Pub> getInstance(Class<Pub> pubClass){
        if(pubClass.isAssignableFrom(SimplePublication.class))
            return (PublicationController<Pub>) provider.getSimplePublicationController();
        return null;
    }

    String create(P publication);
}
