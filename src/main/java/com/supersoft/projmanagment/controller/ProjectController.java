package com.supersoft.projmanagment.controller;

import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.infrastructure.database.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("manager")
public class ProjectController {
    private final ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }


/*
    @GetMapping("/projects")
    CollectionModel<EntityModel<Project>> all() {
        List<EntityModel<Project>> projects = repository.findAll().
                stream().map(projects -> EntityModel.of(projects,
//                linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
                linkTo(methodOn(ProjectController.class).all()).withRel("projects"))).
                collect(Collectors.toList());
        return CollectionModel.of(projects,
                linkTo(methodOn(ProjectController.class).all()).withSelfRel());
    }*/
    @ResponseBody
    @GetMapping("/checkProjects")
    List<Project> checkProjects() {
        return repository.findAll();
    }

    @ResponseBody
    @PostMapping("/CreateProject")
    public String createProject(@RequestParam String projectName, @RequestParam String idManager,
                                @RequestParam Date dateStart, @RequestParam Date dateEnd) {
        String sDate = "01/12/2020";
        String endDate = "31/12/2020";

        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;
        Project newProject = new Project();
        newProject.setProjectName(projectName);
        newProject.setIdManager(idManager);
        newProject.setDateStart(dateStart);
        newProject.setDateEnd(dateEnd);
        repository.save(newProject);
        return "Saved";
    }

/*    @PostMapping(value = "/CreateProject")//Не работает
    void createProject(@RequestBody Project newProject) {
        String sDate = "01/12/2020";
        String endDate = "31/12/2020";
        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;
        *//*newProject = new Project("project1", "1", finalDateStart, finalDateEnd);*//*
        repository.save(newProject);
    }*/
}
