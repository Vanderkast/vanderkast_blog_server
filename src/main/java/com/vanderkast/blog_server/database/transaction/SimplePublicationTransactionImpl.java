package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.database.repository.SimplePublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class SimplePublicationTransactionImpl implements SimplePublicationTransaction {
    private SimplePublicationRepository repository;

    @Override
    public List<SimplePublication> getAll() {
        List<SimplePublication> result = new LinkedList<>();
        for (SimplePublication simplePublication : repository.findAll()) {
            result.add(simplePublication);
        }
        return result;
    }

    @Override
    public String create(SimplePublication publication) {
        return repository.save(publication).getId();
    }

    @Override
    public SimplePublication getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Autowired
    public void setRepository(SimplePublicationRepository repository) {
        this.repository = repository;
    }
}
