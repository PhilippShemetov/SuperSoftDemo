package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "executor")
public class ExecutorAPI {

    @Autowired
    private Server server;

    //Функции связанные с проектами

    @ResponseBody
    @GetMapping("/projects/check/{id}")
    Project checkProject(@PathVariable Long id) {
        //TODO
        return server.startExecutorHandlerCheckProj(id);
    }

    @ResponseBody
    @GetMapping("/projects/check")
    List<Project> checkProjectAll() {
        return server.startExecutorHandlerCheckProjects();
    }

    @ResponseBody
    @GetMapping("/projects/task/check/{id}")
    List<Task> checkTaskInProjAll(@PathVariable Long id) {
        return server.startExecutorHandlerCheckTasksInProject(id);
    }
}
