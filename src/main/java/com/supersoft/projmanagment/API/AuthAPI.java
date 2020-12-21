package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.test.LoginForm;
import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
public class AuthAPI {

    @Autowired
    private Server server;


//    @PostMapping()
//    public User login(@RequestBody LoginForm log) {
//        return server.authHandler(log.login, log.password);
//    }
    @PostMapping()
    public User login(@RequestBody String login, @RequestBody String password) {
        return server.authHandler(login, password);
    }


    /*@ResponseBody
    @GetMapping()
    public List<User> login() {
        return iService.findAll();
    }*/

}
