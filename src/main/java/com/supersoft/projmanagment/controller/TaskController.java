//package com.supersoft.projmanagment.controller;
//
//import com.supersoft.projmanagment.webserver.task.Task;
//import com.supersoft.projmanagment.webserver.task.TaskRepository;
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
//                stream().map(task -> EntityModel.of(task,
////                linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
//                linkTo(methodOn(TaskController.class).all()).withRel("task"))).
//                collect(Collectors.toList());
//        return CollectionModel.of(tasks,
//                linkTo(methodOn(TaskController.class).all()).withSelfRel());
//    }
//}
