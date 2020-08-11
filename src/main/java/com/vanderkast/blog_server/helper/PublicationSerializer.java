package com.vanderkast.blog_server.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.model.Publication;

import java.io.IOException;

public class PublicationSerializer<T extends Publication> extends StdSerializer<T> {
    public PublicationSerializer() {
        this(null);
    }

    public PublicationSerializer(Class<T> t) {
        super(t);
    }

    @Override
    public void serialize(T value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject(value);
        generator.writeStringField("type", value.getType());
        generator.writeNumberField("timestamp", value.getTimestamp());
        if (value instanceof SimplePublication)
            writeSimplePublication((SimplePublication) value, generator);
        generator.writeEndObject();
    }

    private void writeSimplePublication(SimplePublication publication, JsonGenerator generator) throws IOException {
        generator.writeStringField("id", publication.getId());
        generator.writeStringField("title", publication.getTitle());
        generator.writeStringField("content", publication.getContent());
    }
}
