package com.tasks.tasks.dto;

import java.io.Serializable;

public class TaskDto implements Serializable {

    private static final long serialVersionUID = 1L;


    private String name;
    private String description;
    private String status;
    private String assignedTo;
    private String dueDate;
    private String created;

    public TaskDto(){

    }

    public TaskDto(String name, String description, String status, String assignedTo, String dueDate, String created) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
    }
}
