package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.infrastructure.database.ProjectRepository;
import com.supersoft.projmanagment.infrastructure.database.TaskRepository;
import com.supersoft.projmanagment.infrastructure.database.UserRepository;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;
import com.supersoft.projmanagment.webserver.users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ExecutorAPITest {

    @Autowired
    private ExecutorAPI execApi;

    @Autowired
    private ProjectRepository projRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    private final String sDate = "01/12/2020";
    private final String endDate = "31/12/2020";
    private Date dateStart = null;
    private Date dateEnd = null;

    @BeforeEach
    public void deleteRecords() {
        projRepository.deleteAll();
        taskRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    public void checkProjectTest() {
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;
        Project proj = new Project("TestProj", 1L, "hello", finalDateStart, finalDateEnd);
        Project proj2 = new Project("TestProj2", 2L, "hello", finalDateStart, finalDateEnd);
        projRepository.save(proj);
        projRepository.save(proj2);
        Project rep = projRepository.findByProjectName("TestProj2");
        Project proj3 = execApi.checkProject(rep.getIdProject());
        assertThat(proj3.getIdProject().equals(rep.getIdProject()));
    }

    @Test
    public void checkAllProjectTest() {
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;
        Project proj = new Project("TestProj", 1L, "hello", finalDateStart, finalDateEnd);
        Project proj2 = new Project("TestProj2", 2L, "hello", finalDateStart, finalDateEnd);
        projRepository.save(proj);
        projRepository.save(proj2);
        List<Project> rep = execApi.checkProjectAll();

        assertThat(rep.size() == 2);
    }

    @Test
    public void checkTaskInProjAll() {
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;

        Project project = new Project("project1", 1L, "allo", finalDateStart, finalDateEnd);
        Task task1 = new Task("task1", "test1 tasks descr", "new", "test2", finalDateStart, finalDateEnd,1L);
        Task task2 = new Task("task2", "test2 tasks descr", "new", "test3", finalDateStart, finalDateEnd,1L);

        task1.setProject(project);
        task1.setProject(project);
        project.addTask(task1);
        project.addTask(task2);
        projRepository.save(project);
        assertThat(execApi.checkTaskInProjAll(project.getIdProject()).size() == 2);
    }

}
