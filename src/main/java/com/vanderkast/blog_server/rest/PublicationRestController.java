package com.vanderkast.blog_server.rest;

import com.vanderkast.blog_server.controller.ControllersFacade;
import com.vanderkast.blog_server.domain.Publication;
import com.vanderkast.blog_server.rest.model.CompositePublication;
import com.vanderkast.blog_server.rest.model.Morph;
import com.vanderkast.blog_server.rest.model.MorphKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/publication")
public class PublicationRestController {
    private ControllersFacade controllersFacade;
    private MorphKeeper morphKeeper;

    @GetMapping
    public @ResponseBody
    ResponseEntity<List<CompositePublication>> readAll() {
        return ResponseEntity.ok(
                controllersFacade.readAll()
                        .stream()
                        .map(morphKeeper::handle)
                        .collect(Collectors.toList()));
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<String> create(@RequestBody CompositePublication composite) {
        Publication publication = Morph.getInstance(composite.getTypeName()).handle(composite);
        return ResponseEntity.ok(controllersFacade.save(publication));
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Void> delete(@PathVariable("id") String id) {
        controllersFacade.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    public void setControllersFacade(ControllersFacade controllersFacade) {
        this.controllersFacade = controllersFacade;
    }

    @Autowired
    public void setMorphKeeper(MorphKeeper morphKeeper) {
        this.morphKeeper = morphKeeper;
    }
}
