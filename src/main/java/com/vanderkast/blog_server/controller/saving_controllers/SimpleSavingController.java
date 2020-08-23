package com.vanderkast.blog_server.controller.saving_controllers;

import com.vanderkast.blog_server.database.transaction.SavePublicationTransaction;
import com.vanderkast.blog_server.domain.SimplePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SimpleSavingController implements SavingController<SimplePublication> {
    private final SavePublicationTransaction<SimplePublication> savePublicationTransaction;

    @Autowired
    public SimpleSavingController(SavePublicationTransaction<SimplePublication> savePublicationTransaction) {
        this.savePublicationTransaction = savePublicationTransaction;
    }

    @Override
    public String save(SimplePublication publication) {
        if (publication.getId() == null)
            publication.setTimestamp(new Date().getTime());

        return savePublicationTransaction.save(publication);
    }
}
