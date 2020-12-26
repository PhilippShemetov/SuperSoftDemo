package com.supersoft.projmanagment.webserver.users;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("could not find user with id: " + id);
    }
}
