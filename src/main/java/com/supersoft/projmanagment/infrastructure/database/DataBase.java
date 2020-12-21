package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.API.ManagerAPI;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.projects.ProjectNotFoundException;
import com.supersoft.projmanagment.webserver.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DataBase implements IDataBase {

    //    private static IDataBase instance;
    Logger logger = LoggerFactory.getLogger(ManagerAPI.class);
    @Autowired
    private UserRepository repository;

    @Autowired
    private ProjectRepository projReository;

//    public DataBase(UserRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public User getUser(String login, String password) {
        return repository.findByLoginAndPassword(login, password);
    }

    @Override
    public Boolean createUser() {
        return null;
    }

    @Override
    public void createNewProject(String projectName, Long idManager, String description, Date dateStart, Date dateEnd) {
        Project proj = new Project(projectName, idManager, description, dateStart, dateEnd);
        projReository.save(proj);
        logger.info("save - "  + proj);
    }

    @Override
    public void deleteProject(String id) {
        projReository.deleteById(id);
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
        return projReository.findAll();
    }
}
