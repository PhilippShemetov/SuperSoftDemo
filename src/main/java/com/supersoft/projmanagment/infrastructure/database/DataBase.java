package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.controller.ProjectNotFoundException;
import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.projects.Project;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Service
public class DataBase implements IDataBase {

    private static IDataBase instance;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ProjectRepository projReository;

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
    public void createNewProject(String projectName, String idManager, String description, Date dateStart, Date dateEnd, List<User> listOfUsers) {
        Project proj = new Project(projectName, idManager,  listOfUsers, description, dateStart, dateEnd);
        projReository.save(proj);
    }

    @Override
    public Boolean createTask() {
        return null;
    }

    @Override
    public Project checkProject(String id) {
        return projReository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
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
