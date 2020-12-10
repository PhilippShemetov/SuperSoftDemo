package com.supersoft.projmanagment.Project;

import com.supersoft.projmanagment.Task.Task;
import com.supersoft.projmanagment.Users.User;

import java.util.Date;
import java.util.List;

public class Project {
    String projectName;
    String idProject;
    String idManager;
    List<User> listOfUsers;
    List<Task> listOfTasks;
    String description;
    Date dateStart;
    Date dateEnd;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public String getIdManager() {
        return idManager;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public List<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(List<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }


}
