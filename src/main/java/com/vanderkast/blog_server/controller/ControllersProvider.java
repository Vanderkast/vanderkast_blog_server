package com.vanderkast.blog_server.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class ControllersProvider {
    private SimplePublicationController simple;

    @Autowired
    public void setSimple(SimplePublicationController simple) {
        this.simple = simple;
    }

    public SimplePublicationController getSimplePublicationController() {
        return simple;
    }

}
