package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControllersProvider {
    private SimplePublicationController simple;

    @SuppressWarnings("unchecked")
    public <Pub extends Publication> PublicationController<Pub> getInstance(Class<? extends Publication> pubClass) {
        if (pubClass.isAssignableFrom(SimplePublication.class))
            return (PublicationController<Pub>) simple;
        return null;
    }

    @Autowired
    public void setSimple(SimplePublicationController simple) {
        this.simple = simple;
    }
}
