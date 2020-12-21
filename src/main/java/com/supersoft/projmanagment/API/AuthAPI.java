package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
public class AuthAPI {

    @Autowired
    private Server server;


    @PostMapping()
    public User login(@RequestBody User log) {
        return server.authHandler(log.getLogin(), log.getPassword());
    }


    /*@ResponseBody
    @GetMapping()
    public List<User> login() {
        return iService.findAll();
    }*/

}
