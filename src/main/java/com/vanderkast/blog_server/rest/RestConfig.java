package com.vanderkast.blog_server.rest;

import com.vanderkast.blog_server.domain.SimplePublication;
import com.vanderkast.blog_server.rest.model.Morph;
import com.vanderkast.blog_server.rest.model.MorphKeeper;
import com.vanderkast.blog_server.rest.model.MorphSimple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RestConfig {
    @Bean
    MorphKeeper beanMorphKeeper(Morph<SimplePublication> simplePublicationMorph) {
        return new MorphKeeper(simplePublicationMorph);
    }

    @Bean
    Morph<SimplePublication> beanMorphSimplePublication() {
        return new MorphSimple();
    }
}
