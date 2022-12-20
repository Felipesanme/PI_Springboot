package com.bookings.bookings.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "user_collection_MDB")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String idUser;
    private String fullName;
    private String email;
    private String password;

    public User(){

    }

    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }


    public User(UserDto userDto) {
        this.fullName = userDto.getFullName();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();

    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser= idUser;
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
