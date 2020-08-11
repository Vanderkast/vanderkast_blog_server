package com.vanderkast.blog_server.model;

public interface Publication {
    default String getType() {
        return this.getClass().getSimpleName();
    }

    Long getTimestamp();
}
