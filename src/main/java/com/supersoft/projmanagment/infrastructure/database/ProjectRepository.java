package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.webserver.projects.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByProjectName(String name);

}
