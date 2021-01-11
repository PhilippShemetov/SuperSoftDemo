package com.supersoft.projmanagment.webserver.users;

import com.supersoft.projmanagment.infrastructure.database.IDataBase;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class Manager implements IManager {
    @Autowired
    private IDataBase iDataBase;

    @Override
    public Project checkProject(Long id) {
        return iDataBase.checkProject(id);
    }

    @Override
    public void updateTask(Long id, Task task) {
        iDataBase.updateTask(id, task);
    }

    @Override
    public void deleteProject(Long id) {
        iDataBase.deleteProject(id);
    }

    @Override
    public void createTask(Task task) {
        iDataBase.createTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        iDataBase.deleteTask(id);
    }

    @Override
    public void updateProj(Long id, Project project) {
        iDataBase.updateProject(id, project);
    }

    @Override
    public void createNewProject(Project project) {
        iDataBase.createNewProject(project);
    }

    @Override
    public void updateUser(Long id, User user) {
        iDataBase.updateUser(id, user);
    }

    @Override
    public User checkUser(Long id) {
        return iDataBase.checkUser(id);
    }

    @Override
    public List<User> checkAllUsers() {
        return iDataBase.checkAllUsers();
    }

    @Override
    public List<User> checkUsersInProject(Long id) {
        return iDataBase.checkUsersInProject(id);
    }

    @Override
    public Task checkTask(Long id) {
        return iDataBase.checkTask(id);
    }

    @Override
    public List<Task> checkTasksInProject(Long id) {
        return iDataBase.checkTasksInProject(id);
    }

    @Override
    public HashMap<String,Integer> checkStaticProject(Long id) {
        return iDataBase.checkStaticProject(id);
    }

    @Override
    public List<Project> checkProjectAll() {
        return iDataBase.showAllProject();
    }
}
