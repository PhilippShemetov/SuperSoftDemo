package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.test.IService;
import com.supersoft.projmanagment.test.LoginForm;
import com.supersoft.projmanagment.webserver.kernel.Server;
import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "auth")
public class AuthAPI {

    @Autowired
    private Server server;
    @Autowired
    private IService iService;


    @PostMapping()
    public User login(@RequestBody LoginForm log) {
        return server.authHandler(log.login, log.password);
    }

    /*@ResponseBody
    @GetMapping()
    public List<User> login() {
        return iService.findAll();
    }*/
}
