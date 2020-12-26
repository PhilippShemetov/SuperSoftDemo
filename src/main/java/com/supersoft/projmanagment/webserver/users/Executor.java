package com.supersoft.projmanagment.webserver.users;

import com.supersoft.projmanagment.infrastructure.database.IDataBase;
import com.supersoft.projmanagment.webserver.projects.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Executor implements IExecutor{
    @Autowired
    private IDataBase iDataBase;

    @Override
    public List<Project> checkProjectAll() {
        return iDataBase.showAllProject();
    }

    @Override
    public Project checkProject(Long id) {
        return iDataBase.checkProject(id);
    }
}
