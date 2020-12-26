package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.infrastructure.database.ProjectRepository;
import com.supersoft.projmanagment.infrastructure.database.TaskRepository;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.tasks.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ManagerAPITest {

    @Autowired
    private ManagerAPI mngApi;

    @Autowired
    private ProjectRepository projRepository;

    @Autowired
    private TaskRepository taskRepository;

    private final String sDate = "01/12/2020";
    private final String endDate = "31/12/2020";
    private Date dateStart = null;
    private Date dateEnd = null;

    @Test
    public void checkInitManagerTest() {
        assertThat(mngApi).isNotNull();

    }

    @AfterEach
    public void deleteRecords() {
        projRepository.deleteAll();
    }

    @Test
    public void createProjectTest() {

        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;
        Project proj = new Project("TestProj", 1L, "hello", finalDateStart, finalDateEnd);
        mngApi.createProject(proj);
        Project rep = projRepository.findByProjectName("TestProj");
        assertThat(rep.getProjectName().equals(proj.getProjectName()));

    }

    @Test
    public void deleteProjectTest() {

        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;
        Project proj = new Project("TestProj", 1L, "hello", finalDateStart, finalDateEnd);
        mngApi.createProject(proj);
        assertThat(projRepository.existsById(1L) == false);


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
        Project proj3 = mngApi.checkProject(rep.getIdProject());
        mngApi.deleteProject(proj3.getIdProject());
        assertThat(proj3.getIdProject().equals(rep.getIdProject()));

    }

    @Test
    public void createTaskTest() {
        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;

        Project project = new Project("project2", 1L, "allo", finalDateStart, finalDateEnd);
        mngApi.createProject(project);
        Project rep = projRepository.findByProjectName("project2");
        Task task = new Task("task1", "test1 tasks descr",
                true, "test2", finalDateStart, finalDateEnd, rep.getIdProject());
        mngApi.createTask(task);
        assertThat(taskRepository.existsByTaskName("task1"));
    }

    @Test
    public void getParentProjTaskTest() {
        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;

        Project project = new Project("project2", 1L, "allo", finalDateStart, finalDateEnd);
//        User user1 = new User();
//        User user2 = new User();
//        user1.setFirstName("Philipp");
//        user1.setProject(project);
//        user2.setFirstName("Misha");
//        user2.setProject(project);
        mngApi.createProject(project);
        Project rep = projRepository.findByProjectName("project2");
        Task task = new Task("task1", "test1 tasks descr",
                true, "test2", finalDateStart, finalDateEnd, rep.getIdProject());
        mngApi.createTask(task);
        Task repTask = taskRepository.findByTaskName("task1");
        assertThat(repTask.getIdProject() == rep.getIdProject());
    }
}
