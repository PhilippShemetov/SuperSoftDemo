package com.supersoft.projmanagment.API;

import com.supersoft.projmanagment.infrastructure.database.ProjectRepository;
import com.supersoft.projmanagment.infrastructure.database.UserRepository;
import com.supersoft.projmanagment.webserver.users.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthAPITest {

    @Autowired
    private AuthAPI auth;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void authorizationUserTest() {
        User usr = new User("Bob", "Anderson", "test1", "123", "manager");
        userRepository.save(usr);
        User authUser = auth.login(usr);
        assertThat(authUser.getFirstName().equals("Bob"));
    }
}
