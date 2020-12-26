package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.webserver.tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Boolean existsByTaskName(String taskName);
    Task findByTaskName(String taskName);
}
