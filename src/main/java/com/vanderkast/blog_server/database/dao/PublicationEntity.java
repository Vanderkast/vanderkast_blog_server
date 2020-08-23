package com.vanderkast.blog_server.database.dao;

import com.vanderkast.blog_server.domain.Publication;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class PublicationEntity implements Publication {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(updatable = false)
    private Long timestamp;

    @Enumerated(EnumType.STRING)
    private Publication.Type type;


    public PublicationEntity() {
    }

    public PublicationEntity(String id, Long timestamp, Type type) {
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Publication.Type getType() {
        return type;
    }

    public void setType(Publication.Type type) {
        this.type = type;
    }
}
