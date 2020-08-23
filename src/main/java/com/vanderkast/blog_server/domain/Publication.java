package com.vanderkast.blog_server.domain;

/**
 * Publication root abstraction
 *
 * string type provides
 */
public interface Publication {

    Type getType();

    String getId();

    Long getTimestamp();

    enum Type {
        SIMPLE
    }
}
