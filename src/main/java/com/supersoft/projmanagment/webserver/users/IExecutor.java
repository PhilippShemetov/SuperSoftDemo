package com.supersoft.projmanagment.webserver.users;

import com.supersoft.projmanagment.webserver.projects.Project;

import java.util.List;

public interface IExecutor {

    Project checkProject(Long id);

    List<Project> checkProjectAll();

}
