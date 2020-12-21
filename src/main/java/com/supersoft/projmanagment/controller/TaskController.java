//package com.supersoft.projmanagment.controller;
//
//import com.supersoft.projmanagment.webserver.tasks.Task;
//import com.supersoft.projmanagment.infrastructure.database.TaskRepository;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
//@RestController
//public class TaskController {
//    public final TaskRepository repository;
//
//    public TaskController(TaskRepository taskRepository) {
//        this.repository = taskRepository;
//    }
//
//    @GetMapping("/tasks")
//    CollectionModel<EntityModel<Task>> all() {
//        List<EntityModel<Task>> tasks = repository.findAll().
//                stream().map(tasks -> EntityModel.of(tasks,
////                linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
//                linkTo(methodOn(TaskController.class).all()).withRel("tasks"))).
//                collect(Collectors.toList());
//        return CollectionModel.of(tasks,
//                linkTo(methodOn(TaskController.class).all()).withSelfRel());
//    }
//}
