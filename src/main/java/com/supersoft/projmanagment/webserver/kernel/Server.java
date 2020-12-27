package com.supersoft.projmanagment.webserver.kernel;

import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;
import com.supersoft.projmanagment.webserver.users.IExecutor;
import com.supersoft.projmanagment.webserver.users.IManager;
import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.users.auth.Authorisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Server {
    private static Server instance = null;
    @Autowired
    private Authorisation authorisation;

    @Autowired
    private IManager mngHandler;

    @Autowired
    private IExecutor extrHandler;

    //Обработка менеджера

    public Project startManagerHandlerCheckProj(Long id) {
        return mngHandler.checkProject(id);
    }

    public void startManagerHandlerDeleteProj(Long id) {
        mngHandler.deleteProject(id);
    }

    public void startManagerHandler(Project project) {
        mngHandler.createNewProject(project);
    }


    public void startManagerHandlerCreateTask(Task task) {
        mngHandler.createTask(task);
    }

    public Task startManagerHandlerCheckTask(Long id) {
        return mngHandler.checkTask(id);
    }

    public List<Project> startManagerHandlerCheckProjects() {
        return mngHandler.checkProjectAll();
    }


    public void startManagerHandlerDeleteTask(Long id) {
        mngHandler.deleteTask(id);
    }

    public void startManagerHandlerUpdateProj(Long id, Project project) {
        mngHandler.updateProj(id, project);
    }

    public void startManagerHandlerUpdateTask(Long id, Task task) {
        mngHandler.updateTask(id, task);
    }

    public void startManagerHandlerUpdateUser(Long id, User user) {
        mngHandler.updateUser(id,user);
    }

    public User startManagerHandlerCheckUser(Long id) {
        return mngHandler.checkUser(id);
    }

    public List<User> startManagerHandlerCheckUsersInProj(Long id) {
        return mngHandler.checkUsersInProject(id);
    }

    public List<User> startManagerHandlerCheckAllUser() {
        return mngHandler.checkAllUsers();
    }

    public List<Task> startManagerHandlerCheckTasksInProject(Long id) {
        return mngHandler.checkTasksInProject(id);
    }

    //Авторизация

    public User authHandler(String login, String password) {
        return authorisation.auth(login, password);
    }

    //Обработка исполнителя

    public List<Project> startExecutorHandlerCheckProjects() {
        return extrHandler.checkProjectAll();
    }

    public Project startExecutorHandlerCheckProj(Long id) {
        return extrHandler.checkProject(id);
    }

    public List<Task> startExecutorHandlerCheckTasksInProject(Long id) {
        return extrHandler.checkTasksInProject(id);
    }
}
