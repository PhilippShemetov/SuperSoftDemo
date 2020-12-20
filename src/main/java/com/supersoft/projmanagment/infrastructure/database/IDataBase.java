package com.supersoft.projmanagment.infrastructure.database;
import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.projects.Project;

import java.util.Date;
import java.util.List;

public interface IDataBase {
    User getUser(String login,String password);
    Boolean createUser();
    void createNewProject(String projectName, String idManager, String description, Date dateStart, Date dateEnd, List<User> listOfUsers);
    Boolean createTask();
    Project checkProject(String id);
    Boolean updateProject();
    List<Project> showAllProject();

}
