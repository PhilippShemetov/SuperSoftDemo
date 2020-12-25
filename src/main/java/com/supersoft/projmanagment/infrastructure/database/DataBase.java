package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.API.ManagerAPI;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.projects.ProjectNotFoundException;
import com.supersoft.projmanagment.webserver.tasks.Task;
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
    private ProjectRepository projRepository;

    @Autowired
    private TaskRepository taskRepository;

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
        projRepository.save(proj);
        logger.info("save - "  + proj);
    }

    @Override
    public void createTask(String taskName, String description, Boolean taskStatus, String assignedTo, Date dateStart, Date dateEnd) {
        /*Моя идея заключается в том, что при создание задачи, нам нужно передать id проекта,
        * но как получить id проекта мне еще не известно в плане логики. Через аргумент?*/
    }

    @Override
    public void deleteProject(Long id) {
        checkProject(id);
        projRepository.deleteById(id);
        logger.info("project with id " + id + " has deleted");
    }


    @Override
    public Project checkProject(Long id) {
        return projRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id.toString()));
    }

    @Override
    public Boolean updateProject() {
        return null;
    }

    @Override
    public List<Project> showAllProject() {
        return projRepository.findAll();
    }
}
