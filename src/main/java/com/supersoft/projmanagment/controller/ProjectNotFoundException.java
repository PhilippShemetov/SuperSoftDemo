package com.supersoft.projmanagment.controller;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String id) {
        super("Could not find project " + id);
    }
}
