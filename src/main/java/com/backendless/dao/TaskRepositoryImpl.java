package com.backendless.dao;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.model.Task;
import com.backendless.servercode.BackendlessService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaskRepositoryImpl implements TaskRepository {

    private String baseUrl = "https://api.backendless.com/70935501-E3E2-6CFE-FF97-5563113B3400/E54318A4-C137-D321-FF0F-8AD3D2AFF800/data/Tasks";

    @Override
    public List<Task> getAll() throws UnirestException {
        List<Task> list = new ArrayList<>();
        HttpResponse<JsonNode> response = Unirest.get(baseUrl).asJson();

        if (response.getBody().isArray()) {
            JSONArray array = response.getBody().getArray();

            for (int i = 0; i < array.length() - 1; i++) {
                JSONObject temp = (JSONObject) array.get(i);

                list.add(initializeTask(temp));
            }
        } else {
            JSONObject temp = response.getBody().getObject();

            list.add(initializeTask(temp));
        }

        return list;
    }

    @Override
    public Task addTask(Task task) throws UnirestException {
        Unirest.post(baseUrl)
                .field("name", task.getName())
                .field("Status", task.getStatus())
                .asJson();

        return task;
    }

    @Override
    public Task updateTask(Task task) throws UnirestException {
        Unirest.put(baseUrl + "/" + task.getObjectId())
                .field("name", task.getName())
                .field("Status", task.getStatus())
                .asJson();

        return task;
    }

    @Override
    public Task deleteTask(Task task) throws UnirestException {
        Unirest.delete(baseUrl + "/" + task.getObjectId()).asString();

        return task;
    }

    private Task initializeTask(JSONObject temp) {
        Task task = new Task();
        task.setObjectId(temp.getString("objectId"));
        task.setName(temp.getString("name"));
        task.setStatus(temp.getString("Status"));

        return task;
    }
}