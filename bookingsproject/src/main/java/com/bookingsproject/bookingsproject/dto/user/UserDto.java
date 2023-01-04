package com.bookingsproject.bookingsproject.dto.user;

import java.io.Serializable;
import java.time.LocalDate;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fullName;
    private String email;
    private String password;


    public UserDto() {
    }

    public UserDto(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;

    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
