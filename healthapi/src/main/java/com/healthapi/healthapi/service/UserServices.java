package com.healthapi.healthapi.service;

import com.healthapi.healthapi.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServices implements UserServicesI{

    HashMap<Integer,User> userInfo = new HashMap<>();

    @Override
    public HashMap<Integer, User> all() {
        return userInfo;
    }

    @Override
    public User findById(Integer id) {
        return userInfo.get(id);
    }

    @Override
    public User createUser(User user) {
        Integer key = user.getUserId();
        return userInfo.put(key,user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        return userInfo.put(id,user);
    }

    @Override
    public void deleteUser(Integer id) {
        userInfo.remove(id);
    }
}
