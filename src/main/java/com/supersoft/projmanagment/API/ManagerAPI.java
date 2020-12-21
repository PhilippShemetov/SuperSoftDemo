package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.projects.Project;
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

    @DeleteMapping("/projects/delete/{id}")
    void deleteEmployee(@PathVariable Long id) {
        server.startManagerHandlerDelete(id);
    }


}
