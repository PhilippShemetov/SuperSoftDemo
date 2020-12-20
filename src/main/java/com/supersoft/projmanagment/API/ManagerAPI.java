package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    Project checkProject(@PathVariable String id) {
        return server.startManagerHandler(id);
    }

    @ResponseBody
    @PostMapping("/projects/create")
    public String createProject(@RequestParam String projectName, @RequestParam String idManager, @RequestParam String description,
                                @RequestParam Date dateStart, @RequestParam Date dateEnd, @RequestParam List<User> listOfUsers) {
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


        User user = new User();
        User user2 = new User();
        user.setFirstName("Philipp");
        user2.setFirstName("Misha");
        listOfUsers.add(user);
        listOfUsers.add(user2);


        server.startManagerHandler(projectName, idManager, description, dateStart, dateEnd, listOfUsers);
        //repository.save(newProject);
        return "Saved";
    }

}
