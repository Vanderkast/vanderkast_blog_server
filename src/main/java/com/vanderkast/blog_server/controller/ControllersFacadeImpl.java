package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.domain.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ControllersFacadeImpl implements ControllersFacade {
    private final ControllersProvider provider;
    private final ReadController readController;

    @Autowired
    public ControllersFacadeImpl(ControllersProvider provider, ReadController readController) {
        this.provider = provider;
        this.readController = readController;
    }

    @Override
    public String save(Publication publication) {
        return provider.getInstance(publication.getType()).save(publication);
    }

    @Override
    public List<Publication> readAll() {
        return readController.readAll();
    }

    @Override
    public void delete(String id) {
        provider.getDeletionController().delete(id);
    }
}
