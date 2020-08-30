package com.vanderkast.blog_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {
        "com.vanderkast.blog_server.controller",
        "com.vanderkast.blog_server.database.transaction",
        "com.vanderkast.blog_server.rest"
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
