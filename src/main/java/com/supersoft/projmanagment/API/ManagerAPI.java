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
    public String createProject(@RequestBody Project project) {
//    public String createProject(@RequestParam String projectName, @RequestParam Long idManager,
//                                @RequestParam String description,
//                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateStart,
//                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateEnd) {
//        @RequestParam("date")
//                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//        String sDate = "01/12/2020";
//        String endDate = "31/12/2020";
//
//        try {
//            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
//            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Date finalDateStart = dateStart;
//        Date finalDateEnd = dateEnd;
//
//
//        User user = new User();
//        User user2 = new User();
//        user.setFirstName("Philipp");
//        user2.setFirstName("Misha");
        //listOfUsers.add(user);
        //listOfUsers.add(user2);


//        server.startManagerHandler(projectName, idManager, description, dateStart, dateEnd);
        server.startManagerHandler(project.getProjectName(), project.getIdManager(),
                project.getDescription(), project.getDateStart(),project.getDateEnd());
        //repository.save(newProject);
        return "Saved";
    }

    @DeleteMapping("/projects/delete/{id}")
    void deleteEmployee(@PathVariable Long id) {
        server.startManagerHandlerDelete(id);
    }


}
