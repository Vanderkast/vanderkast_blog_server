package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.model.Publication;

public interface PublicationController<P extends Publication> {
    String create(P publication);
}
