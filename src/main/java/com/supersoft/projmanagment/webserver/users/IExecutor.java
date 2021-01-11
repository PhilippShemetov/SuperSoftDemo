package com.supersoft.projmanagment.webserver.users;

import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;

import java.util.List;

public interface IExecutor {

    Project checkProject(Long id);

    List<Project> checkProjectAll();

    List<Task> checkTasksInProject(Long id);
}
