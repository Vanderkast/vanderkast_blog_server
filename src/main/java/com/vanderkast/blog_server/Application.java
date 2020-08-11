package com.vanderkast.blog_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;

@SpringBootApplication(scanBasePackages = {
        "com.vanderkast.blog_server.controller",
        "com.vanderkast.blog_server.database.transaction",
        "com.vanderkast.blog_server.rest",
        "com.vanderkast.blog_server.helper",
})
@PropertySource("classpath:application.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }

    @Bean
    ServletWebServerFactory beanServletWebServerFactory() {return new TomcatServletWebServerFactory();}
}
