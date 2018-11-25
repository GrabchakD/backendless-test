package com.backendless.controllers;

import com.backendless.model.Task;
import com.backendless.services.TaskService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> showAllTasks() throws UnirestException {
        return taskService.getAll();
    }
}
