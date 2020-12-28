package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.webserver.tasks.Task;
import com.supersoft.projmanagment.webserver.users.User;
import com.supersoft.projmanagment.webserver.projects.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final String sDate = "01/12/2020";
    private final String endDate = "31/12/2020";
    private Date dateStart = null;
    private Date dateEnd = null;

    @Bean
    CommandLineRunner initUsers(UserRepository repository) {
        User user1 = new User("Philipp","Shemetov","admin1","123","executor");
        User user2 = new User("Misha","Kurakin","admin2","123","executor");
        User user3 = new User("Katya","Guseva","admin3","123","manager");
        User user4 = new User("Artem","Sadikov","admin4","123","manager");
        User user5 = new User("Vika","Makarova","admin5","123","manager");

        return args -> {
            log.info("Preloading " + repository.save(user1));
            log.info("Preloading " + repository.save(user2));
            log.info("Preloading " + repository.save(user3));
            log.info("Preloading " + repository.save(user4));
            log.info("Preloading " + repository.save(user5));
        };
    }
}
