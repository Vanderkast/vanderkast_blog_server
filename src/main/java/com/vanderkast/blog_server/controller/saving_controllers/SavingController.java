package com.vanderkast.blog_server.controller.saving_controllers;

import com.vanderkast.blog_server.domain.Publication;

public interface SavingController<P extends Publication> {
    String save(P publication);
}
