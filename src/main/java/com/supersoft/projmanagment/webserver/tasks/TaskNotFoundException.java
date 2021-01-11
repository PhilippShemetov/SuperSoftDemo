package com.supersoft.projmanagment.webserver.tasks;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String id){
        super("could not find task with id: " + id);
    }
}
