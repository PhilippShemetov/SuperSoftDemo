package com.supersoft.projmanagment.webserver.users;

import com.supersoft.projmanagment.infrastructure.database.IDataBase;
import com.supersoft.projmanagment.webserver.projects.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public void createNewProject(String projectName, Long idManager,String description, Date dateStart, Date dateEnd) {
        iDataBase.createNewProject(projectName, idManager, description, dateStart, dateEnd);
    }

    @Override
    public void deleteProject(Long id) {
        iDataBase.deleteProject(id);
    }

    @Override
    public void createTask(String taskName, String description, Boolean taskStatus, String assignedTo, Date dateStart, Date dateEnd) {
        iDataBase.createTask(taskName,description,taskStatus, assignedTo, dateStart, dateEnd);
    }

    @Override
    public List<Project> checkProjectAll() {
        return iDataBase.showAllProject();
    }
}
