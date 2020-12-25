package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "manager")
public class ManagerAPI {

    @Autowired
    private Server server;
//    private Server server = Server.getInstance();

    @ResponseBody
    @GetMapping("/projects/check/{id}")
    Project checkProject(@PathVariable Long id) {
        return server.startManagerHandler(id);
    }

    @ResponseBody
    @GetMapping("/projects/check")
    List<Project> checkProjectAll() {
        return server.startManagerHandler();
    }

    @ResponseBody
    @PostMapping("/projects/create")
    public void createProject(@RequestBody Project project) {
        server.startManagerHandler(project.getProjectName(), project.getIdManager(),
                project.getDescription(), project.getDateStart(),project.getDateEnd());
    }

    @ResponseBody
    @PostMapping("/task/create")
    public void createTask(@RequestBody Task task) {
        server.startManagerHandler(task);
    }

    @DeleteMapping("/projects/delete/{id}")
    void deleteProject(@PathVariable Long id) {
        server.startManagerHandlerDelete(id);
    }


    //TODO check tasks in cur project
    //TODO check users in cur project
    //TODO delete users in cur project
    //TODO delete users in cur project



    // optional
    //TODO update tasks in cur project
    //TODO update projects in cur project
}
