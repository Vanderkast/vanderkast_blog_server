package com.vanderkast.blog_server.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.model.Publication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelpersConfig {
    @Bean
    ObjectMapper beanObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("PublicationSerializer");

        // SERIALIZERS
        module.addSerializer(SimplePublication.class, new PublicationSerializer<>());


        // DESERIALIZERS
        module.addDeserializer(Publication.class, new PublicationDeserializer());


        mapper.registerModule(module);
        return mapper;
    }
}
