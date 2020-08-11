package com.vanderkast.blog_server.controller.get;

import com.vanderkast.blog_server.database.transaction.SimplePublicationTransaction;
import com.vanderkast.blog_server.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class GrandControllerImpl implements GrandController {
    private final SimplePublicationTransaction simplePublicationTransaction;

    @Autowired
    public GrandControllerImpl(SimplePublicationTransaction simplePublicationTransaction) {
        this.simplePublicationTransaction = simplePublicationTransaction;
    }

    @Override
    public List<Publication> getAll() {
        List<Publication> result = new ArrayList<>();
        result.addAll(simplePublicationTransaction.getAll());
        result.sort(Comparator.comparing(Publication::getTimestamp));
        return result;
    }

    @Override
    public void deleteById(String id) {
        simplePublicationTransaction.deleteById(id);
    }
}
