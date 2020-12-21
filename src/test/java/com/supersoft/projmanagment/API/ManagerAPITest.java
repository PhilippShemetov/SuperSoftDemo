package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.infrastructure.database.ProjectRepository;
import com.supersoft.projmanagment.webserver.projects.Project;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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


    @Test
    public void contextLoads() throws Exception {
        assertThat(mngApi).isNotNull();

    }

    @Test
    public void createAndCheckProjectTest() throws Exception{

        String sDate = "01/12/2020";
        String endDate = "31/12/2020";
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
        Project proj = new Project("TestProj",1L,"hello",finalDateStart,finalDateEnd);
        mngApi.createProject(proj);
        Project rep = projRepository.findByIdProject(1L);
        assertThat(rep.getIdProject().equals(1L));

    }

    @Test
    public void deleteProjectTest() throws Exception{

//        Mockito.when(mngApi.deleteProject(1L)).thenReturn("SUCCES");
//        assertThat();


    }
}
