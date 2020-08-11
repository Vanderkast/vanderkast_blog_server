package com.vanderkast.blog_server.rest;

import com.vanderkast.blog_server.controller.ControllersProvider;
import com.vanderkast.blog_server.controller.get.GrandController;
import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publication")
public class PublicationRestController {
    private final ControllersProvider controllersProvider;
    private final GrandController grandController;

    @Autowired
    public PublicationRestController(ControllersProvider controllersProvider, GrandController grandController) {
        this.controllersProvider = controllersProvider;
        this.grandController = grandController;
    }

    @GetMapping("all")
    public @ResponseBody
    ResponseEntity<List<Publication>> getAll() {
        return ResponseEntity.ok(grandController.getAll());
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void deleteById(@PathVariable String id) {
        grandController.deleteById(id);
    }

    @PostMapping("simple")
    public @ResponseBody
    ResponseEntity<String> create(@RequestBody SimplePublication publication) {
        return ResponseEntity.ok(controllersProvider.getInstance(publication.getClass()).create(publication));
    }
}
