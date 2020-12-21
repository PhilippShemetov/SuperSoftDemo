//package com.supersoft.projmanagment.controller;
//
//import com.supersoft.projmanagment.webserver.users.User;
//import com.supersoft.projmanagment.infrastructure.database.UserRepository;
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
//public class UserController {
//    private final UserRepository repository;
//
//    UserController(UserRepository repository) {
//        this.repository = repository;
//    }
//
//    @GetMapping("/users")
//    CollectionModel<EntityModel<User>> all() {
//        List<EntityModel<User>> users = repository.findAll().
//                stream().map(user -> EntityModel.of(user,
////                linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
//                linkTo(methodOn(UserController.class).all()).withRel("users"))).
//                collect(Collectors.toList());
//        return CollectionModel.of(users,
//                linkTo(methodOn(UserController.class).all()).withSelfRel());
//    }
//
//}
