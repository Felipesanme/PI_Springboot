package com.tasks.tasks.service;

import com.tasks.tasks.data.Task;

import java.util.HashMap;


public interface TaskServiceI {

    HashMap<Integer, Task>all();
    Task createTask(Task task);
    Task findTask(Integer id);
    void deleteTask(Integer id);
    Task updateTask(Task task,Integer id);


}
