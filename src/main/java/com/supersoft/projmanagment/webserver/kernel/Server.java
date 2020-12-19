package com.supersoft.projmanagment.webserver.kernel;

import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.users.auth.Authorisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Server {
    private static Server instance = null;
    @Autowired
    private Authorisation authorisation;


    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    public void startManagerHandler(String request) {

    }

    public User authHandler(String login, String password) {
        return authorisation.auth(login,password);
    }
}
