package com.healthapi.healthapi.service;

import com.healthapi.healthapi.model.User;

import java.util.HashMap;

public interface UserServicesI {
    HashMap<Integer, User> all();

    User findById(Integer id);
    User createUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);
}
