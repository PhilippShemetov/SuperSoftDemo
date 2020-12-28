package com.supersoft.projmanagment.webserver.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supersoft.projmanagment.infrastructure.database.ProjectRepository;
import com.supersoft.projmanagment.webserver.projects.Project;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long taskId;

    String taskName;

    String description;

    Boolean taskStatus;

    String assignedTo;

    Date dateStart;

    Date dateEnd;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "id_project")
    private Project project;

    @Column(name = "id_project", insertable = false, updatable = false)
    private Long idProject;


    public Task() {

    }
    public Task(String taskName, String description, Boolean taskStatus, String assignedTo, Date dateStart, Date dateEnd,Long idProject) {
        this.taskName = taskName;
        this.description = description;
        this.taskStatus = taskStatus;
        this.assignedTo = assignedTo;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.idProject = idProject;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
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
        Task task = (Task) o;
        return taskId.equals(task.taskId) && taskName.equals(task.taskName) && assignedTo.equals(task.assignedTo) && Objects.equals(dateStart, task.dateStart) && Objects.equals(dateEnd, task.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskName, assignedTo, dateStart, dateEnd);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", taskStatus=" + taskStatus +
                ", assignedTo='" + assignedTo + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
