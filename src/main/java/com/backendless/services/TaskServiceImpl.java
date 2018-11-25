package com.backendless.services;

import com.backendless.dao.TaskRepository;
import com.backendless.model.Task;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAll() throws UnirestException {
        return taskRepository.getAll();
    }

    @Override
    public Task addTask(Task task) throws UnirestException {
        return taskRepository.addTask(task);
    }

    @Override
    public Task updateTask(Task task) throws UnirestException {
        return taskRepository.updateTask(task);
    }

    @Override
    public Task deleteTask(Task task) throws UnirestException {
        return taskRepository.deleteTask(task);
    }
}
