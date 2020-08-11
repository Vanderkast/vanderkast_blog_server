package com.vanderkast.blog_server.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.model.Publication;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Optional;

public class PublicationDeserializer extends StdDeserializer<Publication> {
    public PublicationDeserializer() {
        this(null);
    }

    public PublicationDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public @Nullable
    Publication deserialize(JsonParser parser, DeserializationContext context) {
        Publication publication = null;
        JsonNode node = null;
        try {
            node = parser.getCodec().readTree(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String type = node.get("type").asText();
        if (type.equals(SimplePublication.class.getSimpleName())) {
            publication = new SimplePublication();
            SimplePublication simple = (SimplePublication) publication;
            Optional.ofNullable(node.get("id")).ifPresent(v -> simple.setId(v.asText()));
            Optional.ofNullable(node.get("title")).ifPresent(v -> simple.setTitle(v.asText()));
            Optional.ofNullable(node.get("content")).ifPresent(v -> simple.setContent(v.asText()));
            Optional.ofNullable(node.get("timestamp")).ifPresent(v -> simple.setTimestamp(v.asLong()));
        }
        return publication;
    }
}
