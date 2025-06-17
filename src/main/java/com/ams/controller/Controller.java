package com.ams.controller;

import com.ams.aspect.LogExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("CommonController")
@RequestMapping("/common")
public class Controller {

    @Autowired
    Environment environment;

    @GetMapping("/environments")
    @LogExecutionTime
    public String[] getEnvironments() {
        return environment.getActiveProfiles();
    }
}
