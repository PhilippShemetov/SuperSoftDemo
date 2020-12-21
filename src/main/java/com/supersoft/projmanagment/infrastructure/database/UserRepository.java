package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.webserver.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);
}
