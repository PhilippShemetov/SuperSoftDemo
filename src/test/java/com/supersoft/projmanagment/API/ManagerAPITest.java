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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ManagerAPITest {

    @Autowired
    private ManagerAPI mngApi;

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

    @Test
    public void checkInitManagerTest() {
        assertThat(mngApi).isNotNull();
    }


    @BeforeEach
    public void deleteRecords() {
        projRepository.deleteAll();
        taskRepository.deleteAll();
        userRepository.deleteAll();
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
        mngApi.deleteProject(proj.getIdProject());
        assertThat(!projRepository.existsById(proj.getIdProject()));


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
        List<Project> rep = mngApi.checkProjectAll();

        assertThat(rep.size() == 2);
    }

    @Test
    public void checkTaskInProject() {
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;
        Project proj = new Project("TestProj", 1L, "hello", finalDateStart, finalDateEnd);
        Task task = new Task("taskName","des","new","null",finalDateStart,finalDateEnd,1L);
        List<Task> listOfTask = new ArrayList<>();
        listOfTask.add(task);
        proj.setListOfTasks(listOfTask);
        projRepository.save(proj);

        Task task1 = mngApi.checkTasks(task.getTaskId());
        List<Task> listOfTask2 = proj.getListOfTasks();

        assertThat(task1.getTaskName().equals(listOfTask2.get(0).getTaskName()));
    }

    @Test
    public void checkAllUsers() {
        User user1 = new User("Philipp", "Shemetov", "admin1", "123", "executor");
        User user2 = new User("Misha", "Kurakin", "admin2", "123", "executor");
        User user3 = new User("Katya", "Guseva", "admin3", "123", "manager");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        List<User> rep = mngApi.checkAllUser();

        assertThat(rep.size() == 3);
    }

    @Test
    public void checkUser() {
        User user1 = new User("Philipp", "Shemetov", "admin1", "123", "executor");
        User user2 = new User("Misha", "Kurakin", "admin2", "123", "executor");
        User user3 = new User("Katya", "Guseva", "admin3", "123", "manager");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        assertThat(mngApi.checkUser(user1.getIdUser()).equals(user1));
    }

    @Test
    public void updateProjectTest() {
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
        Project rep = projRepository.findByProjectName("TestProj");
        mngApi.updateProject(rep.getIdProject(), proj2);
        assertThat(rep.getProjectName().equals("TestProj2"));

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
                "new", "test2", finalDateStart, finalDateEnd, rep.getIdProject());
        mngApi.createTask(task);
        assertThat(taskRepository.existsByTaskName("task1"));
    }

    @Test
    public void deleteTaskTest() {
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
                "new", "test2", finalDateStart, finalDateEnd, rep.getIdProject());
        mngApi.createTask(task);
        mngApi.deleteTask(task.getTaskId());
        assertThat(!taskRepository.existsByTaskName("task1"));
    }

    @Test
    public void updateTaskDescrTest() {
        String expectedDescr = "THIS IS NEW DESCRIPTION";
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
                "new", "test2", finalDateStart, finalDateEnd, rep.getIdProject());
        mngApi.createTask(task);
        task.setDescription(expectedDescr);
        mngApi.updateTask(task.getTaskId(),task);
        Task taskFromRep = taskRepository.findByTaskName("task1");
        assertThat(expectedDescr.equals(taskFromRep.getDescription()));
    }

    @Test
    public void updateTaskStatusTest() {
        String expectedStatus = "expire";
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
                "new", "test2", finalDateStart, finalDateEnd, rep.getIdProject());
        mngApi.createTask(task);
        task.setTaskStatus(expectedStatus);
        mngApi.updateTask(task.getTaskId(),task);
        Task taskFromRep = taskRepository.findByTaskName("task1");
        assertThat(taskFromRep.getTaskStatus().equals("expire"));
    }

    @Test
    public void updateTaskProjectToNullTest() {
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
                "new", "test2", finalDateStart, finalDateEnd, rep.getIdProject());
        mngApi.createTask(task);
        task.setProject(null);
        mngApi.updateTask(task.getTaskId(),task);
        Task taskFromRep = taskRepository.findByTaskName("task1");
        assertThat(taskFromRep.getProject() == null);
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
                "new", "test2", finalDateStart, finalDateEnd, rep.getIdProject());
        mngApi.createTask(task);
        Task repTask = taskRepository.findByTaskName("task1");
        assertThat(repTask.getIdProject() == rep.getIdProject());
    }
}
