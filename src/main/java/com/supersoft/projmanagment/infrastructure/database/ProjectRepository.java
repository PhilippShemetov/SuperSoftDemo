package com.supersoft.projmanagment.infrastructure.database;

import com.supersoft.projmanagment.webserver.projects.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
