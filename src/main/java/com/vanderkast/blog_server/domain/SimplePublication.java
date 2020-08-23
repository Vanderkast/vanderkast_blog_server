package com.vanderkast.blog_server.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimplePublication implements Publication {
    private String id;
    private Long timestamp;

    private String title;
    private String content;

    public SimplePublication(String id, Long timestamp, String title, String content) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
        this.content = content;
    }

    @Override
    @JsonProperty("type")
    public Type getType() {
        return Type.SIMPLE;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
