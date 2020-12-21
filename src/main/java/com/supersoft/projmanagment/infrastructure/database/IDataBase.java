package com.supersoft.projmanagment.infrastructure.database;
import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.projects.Project;

import java.util.Date;
import java.util.List;

public interface IDataBase {
    User getUser(String login,String password);
    Boolean createUser();
    void createNewProject(String projectName, Long idManager, String description, Date dateStart, Date dateEnd);
    Boolean createTask();
    Project checkProject(Long id);
    void deleteProject(Long id);
    Boolean updateProject();
    List<Project> showAllProject();

}
