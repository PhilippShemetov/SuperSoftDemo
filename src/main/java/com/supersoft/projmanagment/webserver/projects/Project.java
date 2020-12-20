package com.supersoft.projmanagment.webserver.projects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.supersoft.projmanagment.webserver.users.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idProject;
    private String projectName;
    private String idManager;
    @OneToMany(mappedBy = "User", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<User> listOfUsers; //Error TODO...
//    List<Task> listOfTasks;
    private String description;
    private Date dateStart;
    private Date dateEnd;

    public Project(String projectName, String idManager, List<User> listOfUsers, String description, Date dateStart, Date dateEnd) {
        this.projectName = projectName;
        this.idManager = idManager;
        this.listOfUsers = listOfUsers;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
    public Project(){

    }

    public Project(String projectName, String idManager, Date dateStart, Date dateEnd) {
        this.projectName = projectName;
        this.idManager = idManager;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

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

//    public List<User> getListOfUsers() {
//        return listOfUsers;
//    }
//
//    public void setListOfUsers(List<User> listOfUsers) {
//        this.listOfUsers = listOfUsers;
//    }
//
//    public List<Task> getListOfTasks() {
//        return listOfTasks;
//    }
//
//    public void setListOfTasks(List<Task> listOfTasks) {
//        this.listOfTasks = listOfTasks;
//    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return idProject.equals(project.idProject) && projectName.equals(project.projectName) && idManager.equals(project.idManager) && Objects.equals(dateStart, project.dateStart) && Objects.equals(dateEnd, project.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProject, projectName, idManager, dateStart, dateEnd);
    }

    @Override
    public String toString() {
        return "Project{" +
                "idProject='" + idProject + '\'' +
                ", projectName='" + projectName + '\'' +
                ", idManager='" + idManager + '\'' +
//                ", listOfUsers=" + listOfUsers +
//                ", listOfTasks=" + listOfTasks +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
