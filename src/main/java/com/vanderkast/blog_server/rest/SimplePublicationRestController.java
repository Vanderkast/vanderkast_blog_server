package com.vanderkast.blog_server.rest;

import com.vanderkast.blog_server.controller.ControllersProvider;
import com.vanderkast.blog_server.database.dto.SimplePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/publication")
public class SimplePublicationRestController {
    private ControllersProvider controllersProvider;

    @PostMapping("simple")
    public @ResponseBody
    ResponseEntity<String> create(@RequestBody SimplePublication publication) {
        return ResponseEntity.ok(controllersProvider.getInstance(publication.getClass()).create(publication));
    }

    @Autowired
    public void setControllersProvider(ControllersProvider controllersProvider) {
        this.controllersProvider = controllersProvider;
    }
}
