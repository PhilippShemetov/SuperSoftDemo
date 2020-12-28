package com.supersoft.projmanagment.webserver.projects;

import com.supersoft.projmanagment.webserver.tasks.Task;
import com.supersoft.projmanagment.webserver.users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProject;

    private String projectName;

    private Long idManager;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<User> listOfUsers = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    List<Task> listOfTasks = new ArrayList<>();

    private String description;

    private Date dateStart;

    private Date dateEnd;

    public Project(String projectName, Long idManager, List<User> listOfUsers, List<Task> listOfTasks, String description, Date dateStart, Date dateEnd) {
        this.projectName = projectName;
        this.idManager = idManager;
        this.listOfUsers = listOfUsers;
        this.listOfTasks = listOfTasks;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Project() {

    }

    public Project(Long idProject) {
        setIdProject(idProject);
    }

    public Project(String projectName, Long idManager, String description, Date dateStart, Date dateEnd) {
        this.projectName = projectName;
        this.idManager = idManager;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.listOfUsers = new ArrayList<>();
        this.listOfTasks = new ArrayList<>();
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

    public void addUser(User user) {
        listOfUsers.add(user);
    }

    public void addTask(Task task) {
        listOfTasks.add(task);
    }

    public void removeUser(User user) {
        listOfUsers.remove(user);
    }

    public void removeTask(Task task) {
        listOfTasks.remove(task);
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
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
