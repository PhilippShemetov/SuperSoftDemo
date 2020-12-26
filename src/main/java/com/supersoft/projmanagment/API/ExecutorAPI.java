package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "executor")
public class ExecutorAPI {

    @Autowired
    private Server server;



    @ResponseBody
    @GetMapping("/projects/check/{id}")
    Project checkProject(@PathVariable Long id) {
        //TODO
        return server.startExecutorHandlerCheckProj(id);
    }

    @ResponseBody
    @GetMapping("/projects/check")
    List<Project> checkProjectAll() {
        //TODO
        return server.startExecutorHandlerCheckProjects();
    }

    // свои проекты?? спросить у Темы
    //TODO check project
    //TODO check task
    //TODO update end date
    //TODO check own task


}
