package com.vanderkast.blog_server.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vanderkast.blog_server.domain.Publication;

/**
 * Composite object that keeps data for all types of Publications
 * Should be morphed into domain level Publication object
 */
public class CompositePublication {
    // Publication.class requirements
    private final Publication.Type type;
    private String id;
    private Long timestamp;

    // SimplePublication.class ref
    private final String title;
    private final String content;

    public CompositePublication(
            @JsonProperty("id") String id,
            @JsonProperty("type") String type,
            @JsonProperty("title") String title,
            @JsonProperty("content") String content) {
        this.id = id;
        this.type = Publication.Type.valueOf(type);
        this.title = title;
        this.content = content;
    }

    @JsonIgnore
    public CompositePublication(String id, Publication.Type type, Long timestamp, String title, String content) {
        this.id = id;
        this.type = type;
        this.timestamp = timestamp;
        this.title = title;
        this.content = content;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public String getTypeName() {
        return type.name();
    }

    public Publication.Type getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
