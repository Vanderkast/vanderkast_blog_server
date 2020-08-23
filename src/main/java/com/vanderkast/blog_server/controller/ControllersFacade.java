package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.domain.Publication;

import java.util.List;

public interface ControllersFacade {
    void delete(String id);

    String save(Publication publication);

    List<Publication> readAll();
}
