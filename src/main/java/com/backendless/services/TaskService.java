package com.backendless.services;

import com.backendless.model.Task;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface TaskService {

    List<Task> getAll() throws UnirestException;

    Task addTask(Task task) throws UnirestException;

    Task updateTask(Task task) throws UnirestException;

    Task deleteTask(Task task) throws UnirestException;
}
