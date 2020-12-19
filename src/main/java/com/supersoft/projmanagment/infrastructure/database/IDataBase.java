package com.supersoft.projmanagment.infrastructure.database;
import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.projects.Project;

import java.util.List;

public interface IDataBase {
    User getUser(String login,String password);
    Boolean createUser();
    Boolean createNewProject();
    Boolean createTask();
    Project checkProject();
    Boolean updateProject();
    List<Project> showAllProject();

}
