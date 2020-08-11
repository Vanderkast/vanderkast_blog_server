package com.vanderkast.blog_server.controller.get;

import com.vanderkast.blog_server.model.Publication;

import java.util.List;

public interface GrandController {
    List<Publication> getAll();

    // todo: with current Publication structure it function 'delete by id' is expensive
    void deleteById(String id);
}
