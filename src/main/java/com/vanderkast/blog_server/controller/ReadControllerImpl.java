package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.database.transaction.ReadTransaction;
import com.vanderkast.blog_server.domain.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReadControllerImpl implements ReadController {
    private final ReadTransaction readTransaction;

    @Autowired
    public ReadControllerImpl(ReadTransaction readTransaction) {
        this.readTransaction = readTransaction;
    }

    @Override
    public List<Publication> readAll() {
        return readTransaction.readAll();
    }
}
