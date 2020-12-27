package com.supersoft.projmanagment.infrastructure.database;
import com.supersoft.projmanagment.webserver.tasks.Task;
import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.projects.Project;

import java.util.List;

public interface IDataBase {
    User getUser(String login,String password);

    void createTask(Task task);

    Project checkProject(Long id);

    void deleteProject(Long id);

    Task checkTask(Long id);

    void updateProject(Long id, Project project);

    List<Project> showAllProject();

    void deleteTask(Long id);

    void createNewProject(Project project);

    void updateUser(Long id, User user);

    User checkUser(Long id);

    void updateTask(Long id, Task task);

    List<User> checkUsersInProject(Long id);

    List<User> checkAllUsers();

    List<Task> checkTasksInProject(Long id);
}
