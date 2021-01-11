package com.supersoft.projmanagment;

import com.supersoft.projmanagment.infrastructure.database.ProjectRepository;
import com.supersoft.projmanagment.infrastructure.database.UserRepository;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    private void initProject() {
        final String sDate = "01/12/2020";
        final String endDate = "31/12/2020";
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

        Project project = new Project("project1", 1L, "allo", finalDateStart, finalDateEnd);

        User user1 = new User("Philipp", "Shemetov", "admin6", "123", "executor");
        User user2 = new User("Misha", "Kurakin", "admin7", "123", "executor");


        user1.setProject(project);

        user2.setProject(project);
        project.addUser(user1);
        project.addUser(user2);
        projectRepository.save(project);
    }

    @BeforeEach
    public void deleteRecords() {
        projectRepository.deleteAll();
        initProject();
    }

    @Test
    public void serverCheckProjects() throws Exception {
        String projectsStr = "project1";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/manager/projects/check/", String.class)).contains(projectsStr);
    }
    @Test
    public void serverCheckProject() throws Exception {
        String projectsStr = "project1";
        Project proj = projectRepository.findByProjectName("project1");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/manager/projects/check/"+proj.getIdProject(), String.class)).contains(projectsStr);
    }

    @Test
    public void serverCheckAllUser() throws Exception {
        String expectedStr = "Shemetov";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/manager/users/check", String.class)).contains(expectedStr);
    }

    @Test
    public void serverUsersInProj() throws Exception {
        String projectsStr = "Kurakin";
        Project proj = projectRepository.findByProjectName("project1");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/manager/projects/users/check/" + proj.getIdProject(), String.class)).contains(projectsStr);
    }
    @Test
    public void serverCheckUser() throws Exception {
        String projectsStr = "Vika";
        User user = userRepository.findByLogin("admin5");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/manager/users/check/" + user.getIdUser(), String.class)).contains(projectsStr);
    }
}