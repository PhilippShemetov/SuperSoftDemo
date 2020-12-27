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
    public void updateTask(Long id, Task task) {
        Task task1 = checkTask(id);
        if (task.getTaskName() != null)
            task1.setTaskName(task.getTaskName());
        if (task.getDescription() != null)
            task1.setDescription(task.getDescription());
        if (task.getTaskStatus() != null)
            task1.setTaskStatus(task.getTaskStatus());
        if (task.getAssignedTo() != null)
            task1.setAssignedTo(task.getAssignedTo());
        if (task.getDateStart() != null)
            task1.setDateStart(task.getDateStart());
        if (task.getDateEnd() != null)
            task1.setDateEnd(task.getDateEnd());
        taskRepository.save(task1);
        logger.info("update - " + task);
    }

    @Override
    public List<User> checkUsersInProject(Long id) {
        Project project = checkProject(id);
        return project.getListOfUsers();
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
    public void updateProject(Long id, Project projectNew) {
        Project project1 = checkProject(id);
        if (projectNew.getProjectName() != null)
            project1.setProjectName(projectNew.getProjectName());
        if (projectNew.getDescription() != null)
            project1.setDescription(projectNew.getDescription());
        if (projectNew.getIdManager() != null)
            project1.setIdManager(projectNew.getIdManager());
        if (!projectNew.getListOfUsers().isEmpty()) { // при не пустом списке не парсит и вызывает bad request
            for (User user : project1.getListOfUsers()) {
                if (!projectNew.getListOfUsers().contains(user)) {
                    user.setProject(null);
                }
            }
            for (User user : projectNew.getListOfUsers()) {
                User tempUser = userRepository.findByLogin(user.getLogin());
                tempUser.setProject(projectNew);
            }
        }
        if (!projectNew.getListOfTasks().isEmpty()) { // при не пустом списке не парсит и вызывает bad request
            for (Task task : project1.getListOfTasks()) {
                if (!projectNew.getListOfTasks().contains(task)) {
                    task.setProject(null);
                }
            }
            for (Task task : projectNew.getListOfTasks()) {
                Task tempTask = taskRepository.findByTaskName(task.getTaskName());
                tempTask.setProject(projectNew);
            }
        }
        if (projectNew.getDateStart() != null)
            project1.setDateStart(projectNew.getDateStart());
        if (projectNew.getDateEnd() != null)
            project1.setDateEnd(projectNew.getDateEnd());


        projRepository.save(project1);
        logger.info("update - " + project1);
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
        List<User> listOfUsers = project.getListOfUsers();
        for (User users : listOfUsers) {
            User tempUser = userRepository.findByLogin(users.getLogin());
            tempUser.setProject(project);
        }
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
    public List<User> checkAllUsers() {
        return userRepository.findAll();
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
