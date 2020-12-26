package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.API.ManagerAPI;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.projects.ProjectNotFoundException;
import com.supersoft.projmanagment.webserver.tasks.Task;
import com.supersoft.projmanagment.webserver.tasks.TaskNotFoundException;
import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.users.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class DataBase implements IDataBase {

    Logger logger = LoggerFactory.getLogger(ManagerAPI.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public User getUser(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public void createTask(Task task) {
        Project project = checkProject(task.getIdProject());
        project.addTask(task);
        task.setProject(project);
        taskRepository.save(task);
    }

    @Override
    public void deleteProject(Long id) {
        checkProject(id);
        projRepository.deleteById(id);
        logger.info("project with id " + id + " has deleted");
    }


    @Override
    public Project checkProject(Long id) {
        Project project;
        try {
            project = projRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id.toString()));
        } catch (ProjectNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
        return project;
    }

    @Override
    public void updateProject(Long id, Project project) {
        checkProject(id);
        projRepository.save(project);
        logger.info("update - " + project);
    }

    @Override
    public List<Project> showAllProject() {
        return projRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        checkTask(id);
        taskRepository.deleteById(id);
        logger.info("project with id " + id + " has deleted");
    }

    @Override
    public void createNewProject(Project project) {
        projRepository.save(project);
        logger.info("save - " + project);
    }

    @Override
    public void updateUser(Long id, User user) {
        checkUser(id);
        logger.info("updated - " + user);
    }

    @Override
    public User checkUser(Long id) {
        User user;
        try {
            user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        } catch (ProjectNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
        return user;
    }

    @Override
    public Task checkTask(Long id) {
        Task task;
        try {
            task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id.toString()));
        } catch (ProjectNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
        return task;
    }
}
