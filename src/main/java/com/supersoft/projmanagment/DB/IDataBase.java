package com.supersoft.projmanagment.DB;

import com.supersoft.projmanagment.Project.Project;
import com.supersoft.projmanagment.Users.User;

import java.util.List;

public interface IDataBase {
    User getUser();
    Boolean createUser();
    Boolean createNewProject();
    Boolean createTask();
    Project checkProject();
    Boolean updateProject();
    List<Project> showAllProject();
    
}
