package com.supersoft.projmanagment.API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class ManagerAPI {
    public static void checkProject() {
        System.out.println("check");
    }
}
