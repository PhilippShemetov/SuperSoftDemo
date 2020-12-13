package com.supersoft.projmanagment.controller;

import com.supersoft.projmanagment.model.project.Project;
import com.supersoft.projmanagment.model.project.ProjectRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProjectController {
    public final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/projects")
    CollectionModel<EntityModel<Project>> all() {
        List<EntityModel<Project>> projects = repository.findAll().
                stream().map(project -> EntityModel.of(project,
//                linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
                linkTo(methodOn(TaskController.class).all()).withRel("project"))).
                collect(Collectors.toList());
        return CollectionModel.of(projects,
                linkTo(methodOn(TaskController.class).all()).withSelfRel());
    }
}
