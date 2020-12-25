package com.supersoft.projmanagment.webserver.projects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.supersoft.projmanagment.webserver.users.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_project")
    private Long idProject;

    //@Column(name = "project_name")
    private String projectName;

//    @OneToOne(cascade = CascadeType.ALL)
    //@Column(name = "id_manager")
    private Long idManager;
//    private String users = "1 ,2 ,3, 4";
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL,
    orphanRemoval = true)
    List<User> listOfUsers = new ArrayList<>();
//    List<Task> listOfTasks;
    //*************************

//    List<User> listOfUsers;
//    @OneToMany(mappedBy = "User")
//    public List<User> getObjectList() {
//        return listOfUsers;
//    }


    //*************************

    private String description;

    //@Column(name = "date_start")
    private Date dateStart;

    //@Column(name = "date_end")
    private Date dateEnd;

    public Project(String projectName, Long idManager, List<User> listOfUsers, String description, Date dateStart, Date dateEnd) {
        this.projectName = projectName;
        this.idManager = idManager;
        //this.listOfUsers = listOfUsers;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
    public Project(){

    }

    public Project(String projectName, Long idManager, String description, Date dateStart, Date dateEnd) {
        this.projectName = projectName;
        this.idManager = idManager;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Long getIdManager() {
        return idManager;
    }

    public void setIdManager(Long idManager) {
        this.idManager = idManager;
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }
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
