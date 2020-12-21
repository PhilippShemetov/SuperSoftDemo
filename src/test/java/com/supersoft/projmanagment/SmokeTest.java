package com.supersoft.projmanagment;

import static org.assertj.core.api.Assertions.assertThat;

import com.supersoft.projmanagment.API.ManagerAPI;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ManagerAPI mngApi;

    @Test
    public void contextLoads() throws Exception {
        assertThat(mngApi).isNotNull();
    }
}