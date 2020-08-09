package com.vanderkast.blog_server.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanderkast.blog_server.controller.ControllersProvider;
import com.vanderkast.blog_server.controller.SimplePublicationController;
import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.database.repository.SimplePublicationRepository;
import com.vanderkast.blog_server.database.transaction.SimplePublicationTransaction;
import com.vanderkast.blog_server.database.transaction.SimplePublicationTransactionImpl;
import com.vanderkast.blog_server.helper.MockSimplePublicationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SimplePublicationRestController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SimplePublicationRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    SimplePublication publication = new SimplePublication();

    @RunWith(SpringRunner.class)

    @TestConfiguration
    static class Config {
        @Bean
        SimplePublicationController beanSimplePublicationController() {
            return new SimplePublicationController();
        }

        @Bean
        ControllersProvider beanControllersProvider() {
            return new ControllersProvider();
        }

        @Bean
        SimplePublicationTransaction beanSimplePublicationTransaction() {
            return new SimplePublicationTransactionImpl();
        }

        @Bean
        SimplePublicationRepository beanSimplePublicationRepository() {
            return new MockSimplePublicationRepository();
        }
    }

    @Before
    public void setUp() {
        publication.setContent("test content");
        publication.setTitle("test title");
    }

    @Test
    public void create() throws Exception {
        String id = mockMvc.perform(
                post("/api/publication/simple")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(publication)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertNotNull(id);
    }
}
