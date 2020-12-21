package com.supersoft.projmanagment.webserver.tasks;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    Long taskId;

    @Column(name = "task_name")
    String taskName;

    String description;

    @Column(name = "task_status")
    Boolean taskStatus;

    @Column(name = "assigned_to")
    String assignedTo;

    @Column(name = "date_start")
    Date dateStart;

    @Column(name = "date_end")
    Date dateEnd;

    public Task() {

    }
    public Task(String taskName, String description, Boolean taskStatus, String assignedTo, Date dateStart, Date dateEnd) {
        this.taskName = taskName;
        this.description = description;
        this.taskStatus = taskStatus;
        this.assignedTo = assignedTo;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
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
