package com.supersoft.projmanagment.webserver.projects;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String id) {
        super("Could not find project " + id);
    }


}