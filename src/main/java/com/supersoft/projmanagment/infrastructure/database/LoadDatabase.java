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
        return args -> {
            //log.info("Preloading " + repository.save(new User("test1", "test1", "test1", "123", "manager")));
            //log.info("Preloading " + repository.save(new User("test2", "test2", "test2", "123", "executor")));
        };
    }

    @Bean
    CommandLineRunner initProjects(ProjectRepository repository) {
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date finalDateStart = dateStart;
        Date finalDateEnd = dateEnd;

        Project project = new Project("project1", 1L,"allo", finalDateStart, finalDateEnd);
        User user1 = new User();
        User user2 = new User();
        user1.setFirstName("Philipp");
        user1.setProject(project);
        user2.setFirstName("Misha");
        user2.setProject(project);

        List<User> listOfUsers = Arrays.asList(user1,user2);
        project.setListOfUsers(listOfUsers);
        //Project project2 = new Project("project2", 1L,"hello", finalDateStart, finalDateEnd);
        return args -> {
            log.info("Preloading " + repository.save(project));
            //log.info("Preloading " + repository.save(project2));
        };
    }

    @Bean
    CommandLineRunner initTasks(TaskRepository repository) {
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

//        Project project = new Project("project2", 1L,"allo", finalDateStart, finalDateEnd);
//        User user1 = new User();
//        User user2 = new User();
//        user1.setFirstName("Philipp");
//        user1.setProject(project);
//        user2.setFirstName("Misha");
//        user2.setProject(project);
//
//        List<User> listOfUsers = Arrays.asList(user1,user2);
//        project.setListOfUsers(listOfUsers);

        return args -> {
            log.info("Preloading " + repository.save(new Task("task1", "test1 tasks descr", true, "test2", finalDateStart, finalDateEnd,1L)));
        };
    }
}
