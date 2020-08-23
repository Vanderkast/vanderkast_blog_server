package com.vanderkast.blog_server.database.transaction;

import com.vanderkast.blog_server.database.dao.PublicationDetails;
import com.vanderkast.blog_server.database.repository.PublicationDetailsRepository;
import com.vanderkast.blog_server.domain.Publication;
import com.vanderkast.blog_server.domain.SimplePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReadTransactionImpl implements ReadTransaction {
    private final PublicationDetailsRepository repository;

    @Autowired
    public ReadTransactionImpl(PublicationDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Publication> readAll() {
        return repository.readAllOrderedByTimestamp()
                .stream()
                .map(this::map)
                //.filter(Objects::nonNull) todo: think about null filtering
                .collect(Collectors.toList());
    }

    Publication map(PublicationDetails details) {
        if (details.getPublication().getType() == Publication.Type.SIMPLE) {
            return new SimplePublication(details.getId(),
                    details.getPublication().getTimestamp(),
                    details.getTitle(),
                    details.getContent());
        }
        return null;
    }
}
