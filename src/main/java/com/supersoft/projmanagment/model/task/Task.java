package com.supersoft.projmanagment.model.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String taskId;

    String taskName;
    String description;
    Boolean taskStatus;
    String assignedTo;
    Date dateStart;
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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
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
