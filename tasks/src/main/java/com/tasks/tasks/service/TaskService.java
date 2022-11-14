package com.tasks.tasks.service;

import com.tasks.tasks.data.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TaskService implements TaskServiceI{

    HashMap<Integer, Task> taskInfo = new HashMap<>();

    @Override
    public HashMap<Integer,Task> all() {
        return taskInfo;
    }

    @Override
    public Task createTask(Task task) {
        Integer key = task.getId();
        return taskInfo.put(key,task);
    }

    @Override
    public Task findTask(Integer id) {
        return taskInfo.get(id);
    }

    @Override
    public void deleteTask(Integer id) {
        taskInfo.remove(id);
    }

    @Override
    public Task updateTask(Task task, Integer id) {
        return taskInfo.put(id,task);
    }
}
