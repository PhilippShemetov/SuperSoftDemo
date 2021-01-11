package com.supersoft.projmanagment.webserver.users.auth;

import com.supersoft.projmanagment.infrastructure.database.DataBase;
import com.supersoft.projmanagment.infrastructure.database.IDataBase;
import com.supersoft.projmanagment.webserver.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Authorisation {
    private static final Logger log = LoggerFactory.getLogger(Authorisation.class);
    @Autowired
    private IDataBase iDataBase;
    public User auth(String login, String password) {
        User user = null;
        try {
            user = iDataBase.getUser(login, password);
        } catch (NullPointerException e) {
            log.info(e.getMessage());
        }
        return user;
    }
}
