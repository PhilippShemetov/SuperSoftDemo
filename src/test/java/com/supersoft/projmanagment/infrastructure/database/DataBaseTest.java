package com.supersoft.projmanagment.infrastructure.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DataBaseTest {
    @Autowired
    private ProjectRepository projRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkInitDataBaseProject() {
        assertThat(projRepository).isNotNull();
    }

    @Test
    public void checkInitDataBaseTask() {
        assertThat(taskRepository).isNotNull();
    }

    @Test
    public void checkInitDataBaseUser() {
        assertThat(userRepository).isNotNull();
    }
}
