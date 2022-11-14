package com.tasks.tasks.controller;

import com.tasks.tasks.data.Task;
import com.tasks.tasks.service.TaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1/task")

public class TaskController {

private final TaskServiceI taskServiceI;

@Autowired
public TaskController (TaskServiceI taskServiceI){
    this.taskServiceI = taskServiceI;
}

@GetMapping
public HashMap<Integer, Task> all(){
    return taskServiceI.all();
}

@GetMapping("/{id}")
public Task findTask(@PathVariable("id") Integer id) {
    return taskServiceI.findTask(id);
}

@PostMapping
public Task createTask(@RequestBody Task task){
    return taskServiceI.createTask(task);
}

@PutMapping("/{id}")
public Task updateTask(@PathVariable("id") Integer id, @RequestBody Task task){
    return taskServiceI.updateTask(task,id);
}

@DeleteMapping("/{id}")
public void deleteTask(@PathVariable("id") Integer id){
    taskServiceI.deleteTask(id);
}

}
