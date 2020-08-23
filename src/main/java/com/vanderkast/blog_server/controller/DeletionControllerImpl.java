package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.database.transaction.DeleteTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletionControllerImpl implements DeletionController {
    private final DeleteTransaction deleteTransaction;

    @Autowired
    public DeletionControllerImpl(DeleteTransaction deleteTransaction) {
        this.deleteTransaction = deleteTransaction;
    }

    @Override
    public void delete(String id) {
        deleteTransaction.delete(id);
    }
}
