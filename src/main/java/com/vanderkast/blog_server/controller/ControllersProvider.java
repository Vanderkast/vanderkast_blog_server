package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.controller.saving_controllers.SavingController;
import com.vanderkast.blog_server.controller.saving_controllers.SimpleSavingController;
import com.vanderkast.blog_server.domain.Publication;
import com.vanderkast.blog_server.domain.SimplePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControllersProvider {
    private SavingController<SimplePublication> simple;

    private DeletionController deletionController;

    @SuppressWarnings("unchecked")
    public <Pub extends Publication> SavingController<Pub> getInstance(Publication.Type type) {
        if (type == Publication.Type.SIMPLE)
            return (SavingController<Pub>) simple;
        return null;
    }

    public DeletionController getDeletionController() {
        return deletionController;
    }

    @Autowired
    protected void setSimple(SimpleSavingController simple) {
        this.simple = simple;
    }

    @Autowired
    protected void setDeletionController(DeletionController deletionController) {
        this.deletionController = deletionController;
    }
}
