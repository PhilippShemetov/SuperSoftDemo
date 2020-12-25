package com.supersoft.projmanagment.webserver.users;

import com.supersoft.projmanagment.webserver.projects.Project;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface IManager {
    void createNewProject(String projectName, Long idManager, String description, Date dateStart, Date dateEnd);
    Project checkProject(Long id);
    List<Project> checkProjectAll();
    void deleteProject(Long id);
//    void editProject();
    void createTask(String taskName, String description, Boolean taskStatus, String assignedTo, Date dateStart, Date dateEnd);
//    void getManagerStatistics();
}
