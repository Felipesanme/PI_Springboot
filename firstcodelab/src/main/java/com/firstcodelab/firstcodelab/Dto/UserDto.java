package com.firstcodelab.firstcodelab.Dto;


import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String lastName;

    public UserDto(){

    }

    public UserDto(String name, String email, String lastName) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
    }
}
