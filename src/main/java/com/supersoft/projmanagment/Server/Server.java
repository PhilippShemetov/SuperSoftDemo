package com.supersoft.projmanagment.Server;

import com.supersoft.projmanagment.Users.IManager;
import com.supersoft.projmanagment.Users.Manager;

public class Server {
    public static void startManagerHandler(){
        Manager manag = new Manager();
        manag.createNewProject();
    }
}
