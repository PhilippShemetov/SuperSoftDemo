package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "executor")
public class ExecutorAPI {

    @Autowired
    private Server server;




    /*@ResponseBody
    @GetMapping()
    public List<User> login() {
        return iService.findAll();
    }*/

}
