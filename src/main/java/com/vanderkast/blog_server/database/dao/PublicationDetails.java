package com.vanderkast.blog_server.database.dao;

import javax.persistence.*;

@Entity
public class PublicationDetails {
    @Id
    private String id;

    @OneToOne
    @MapsId
    private PublicationEntity publication;

    // SimplePublication data
    private String title;
    private String content;

    public PublicationEntity getPublication() {
        return publication;
    }

    public void setPublication(PublicationEntity publication) {
        this.publication = publication;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setContent(String text) {
        this.content = text;
    }
}
