package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.infrastructure.database.ProjectRepository;
import com.supersoft.projmanagment.webserver.projects.Project;
import com.supersoft.projmanagment.webserver.projects.ProjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class ManagerAPITest {

    @Autowired
    private ManagerAPI mngApi;

    @Autowired
    private ProjectRepository projRepository;

    private final String sDate = "01/12/2020";
    private final String endDate = "31/12/2020";
    private Date dateStart = null;
    private Date dateEnd = null;

    @Test
    public void checkInitManagerTest() {
        assertThat(mngApi).isNotNull();

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
        Project proj = new Project("TestProj",1L,"hello",finalDateStart,finalDateEnd);
        mngApi.createProject(proj);
        Long lol = proj.getIdProject();
        Project rep = projRepository.findByProjectName("TestProj");
        mngApi.deleteProject(rep.getIdProject());
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
        Project proj = new Project("TestProj",1L,"hello",finalDateStart,finalDateEnd);
        mngApi.createProject(proj);
        mngApi.deleteProject(1L);
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
        Project proj = new Project("TestProj",1L,"hello",finalDateStart,finalDateEnd);
        Project proj2 = new Project("TestProj2",2L,"hello",finalDateStart,finalDateEnd);
        projRepository.save(proj);
        projRepository.save(proj2);
        Project rep = projRepository.findByProjectName("TestProj2");
        Project proj3 = mngApi.checkProject(rep.getIdProject());
        mngApi.deleteProject(proj3.getIdProject());
        assertThat(proj3.getIdProject().equals(rep.getIdProject()));


    }
}
