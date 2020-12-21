package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public User login(@RequestParam String login, @RequestParam String password) {
        return server.authHandler(login, password);
    }


    /*@ResponseBody
    @GetMapping()
    public List<User> login() {
        return iService.findAll();
    }*/

}
