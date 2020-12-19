package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.projects.Project;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "manager")
public class ManagerAPI {

//    private Server server = Server.getInstance();

    @ResponseBody
    @GetMapping("/projects/check")
    List<Project> checkProjects() {
//        server.startManagerHandler("check_projects");
        return new ArrayList<>();
    }

    @ResponseBody
    @PostMapping("/projects/create")
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
//        repository.save(newProject);
        return "Saved";
    }

}
