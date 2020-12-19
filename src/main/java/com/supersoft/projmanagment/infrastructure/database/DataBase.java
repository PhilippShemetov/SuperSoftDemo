package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.projects.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class DataBase implements IDataBase {

    private static IDataBase instance;

    @Autowired
    private UserRepository repository;

//    public DataBase(UserRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public User getUser(String login, String password) {
        return repository.findAll().get(0);
//
//        User user = repository.findByLoginAndPassword(login, password);
//        if (user == null) {
//            throw new NullPointerException("User has not found");
//        }
//        return user;
    }

    @Override
    public Boolean createUser() {
        return null;
    }

    @Override
    public Boolean createNewProject() {
        return null;
    }

    @Override
    public Boolean createTask() {
        return null;
    }

    @Override
    public Project checkProject() {
        return null;
    }

    @Override
    public Boolean updateProject() {
        return null;
    }

    @Override
    public List<Project> showAllProject() {
        return null;
    }
}
