package com.supersoft.projmanagment;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void serverReturnProjects() throws Exception {
        String projectsStr = "[{\"idProject\":1,\"projectName\":\"project1\",\"idManager\":1,\"listOfUsers\":[{\"idUser\":1,\"firstName\":\"Philipp\",\"lastName\":null,\"login\":null,\"accepted\":null,\"userType\":null,\"password\":null}," +
                "{\"idUser\":2,\"firstName\":\"Misha\",\"lastName\":null,\"login\":null,\"accepted\":null,\"userType\":null,\"password\":null}]," +
                "\"listOfTasks\":[],\"description\":\"allo\",\"dateStart\":\"2020-11-30T21:00:00.000+00:00\",\"dateEnd\":\"2020-12-30T21:00:00.000+00:00\"}]";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/manager/projects/check/", String.class)).contains(projectsStr);
    }
}