package com.vanderkast.blog_server.rest;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publication")
public class SimplePublicationController {
    @GetMapping("simple")
    public @ResponseBody
    ResponseEntity<List<SimplePublication>> getAll() {
        return null;
    }


    @PostMapping("simple")
    public @ResponseBody
    ResponseEntity<String> create(@RequestBody SimplePublication publication) {
        return null;
    }
}
