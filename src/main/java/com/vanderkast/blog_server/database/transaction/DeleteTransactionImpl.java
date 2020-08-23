package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.repository.PublicationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTransactionImpl implements DeleteTransaction {
    private final PublicationDetailsRepository repository;

    @Autowired
    public DeleteTransactionImpl(PublicationDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
