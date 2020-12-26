package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;
import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "manager")
public class ManagerAPI {

    @Autowired
    private Server server;

    @ResponseBody
    @GetMapping("/projects/check/{id}")
    Project checkProject(@PathVariable Long id) {
        return server.startManagerHandlerCheckProj(id);
    }

    @ResponseBody
    @GetMapping("/projects/check")
    List<Project> checkProjectAll() {
        return server.startManagerHandlerCheckProjects();
    }

    @ResponseBody
    @PostMapping("/projects/create")
    public void createProject(@RequestBody Project project) {
        server.startManagerHandler(project);
    }

    @ResponseBody
    @PostMapping("/task/create")
    public void createTask(@RequestBody Task task) {
        server.startManagerHandlerCreateTask(task);
    }

    @DeleteMapping("/projects/delete/{id}")
    void deleteProject(@PathVariable Long id) {
        server.startManagerHandlerDeleteProj(id);
    }

    @ResponseBody
    @GetMapping("/task/check/{id}")
    Task checkTasks(@PathVariable Long id) {
        return server.startManagerHandlerCheckTask(id);
    }

    @DeleteMapping("/task/delete/{id}")
    void deleteTask(@PathVariable Long id) {
        server.startManagerHandlerDeleteTask(id);
    }

    @ResponseBody
    @PostMapping("/projects/update/{id}")
    public void updateProject(@PathVariable Long id, @RequestBody Project project) {
        server.startManagerHandlerUpdateProj(id, project);
    }


    // add and delete users to cur project (changing project id)
    @ResponseBody
    @PostMapping("/users/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        server.startManagerHandlerUpdateUser(id, user);
    }

    @ResponseBody
    @GetMapping("/users/check/{id}")
    public User checkUser(@PathVariable Long id) {
        return server.startManagerHandlerCheckUser(id);
    }

    @ResponseBody
    @PostMapping("/task/update/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task) {
        server.startManagerHandlerUpdateTask(id, task);
    }


    // optional
    //TODO update task in cur project (Сделано)
    //TODO check users in cur project check project has this data
    //TODO check tasks in cur project??? check project has this data
}
