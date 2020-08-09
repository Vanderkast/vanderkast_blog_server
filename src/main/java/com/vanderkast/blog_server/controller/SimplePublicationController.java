package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.database.transaction.SimplePublicationTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SimplePublicationController implements PublicationController<SimplePublication> {
    private SimplePublicationTransaction transaction;

    @Override
    public String create(SimplePublication publication) {
        if(publication.getTimestamp() == null)
            publication.setTimestamp(new Date().getTime());
        return transaction.create(publication);
    }

    @Autowired
    public void setTransaction(SimplePublicationTransaction transaction) {
        this.transaction = transaction;
    }
}
