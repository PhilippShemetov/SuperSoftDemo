package com.supersoft.projmanagment.webserver.kernel;

import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;
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

    public User authHandler(String login, String password) {
        return authorisation.auth(login, password);
    }

    public void startManagerHandlerDeleteTask(Long id) {
        mngHandler.deleteTask(id);
    }

    public void startManagerHandlerUpdateProj(Long id, Project project) {
        mngHandler.updateProj(id, project);
    }
}
