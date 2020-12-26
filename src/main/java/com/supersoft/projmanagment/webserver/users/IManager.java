package com.supersoft.projmanagment.webserver.users;

import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;

import java.util.List;

public interface IManager {
    Project checkProject(Long id);

    List<Project> checkProjectAll();

    void deleteProject(Long id);

    Task checkTask(Long id);

    //    void editProject();
    void createTask(Task task);

    void deleteTask(Long id);

    void updateProj(Long id, Project project);

    void createNewProject(Project project);
//    void getManagerStatistics();
}
