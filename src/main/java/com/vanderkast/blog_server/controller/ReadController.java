package com.vanderkast.blog_server.controller;

import com.vanderkast.blog_server.domain.Publication;

import java.util.List;

public interface ReadController {
    List<Publication> readAll();
}
