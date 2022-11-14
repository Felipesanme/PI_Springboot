package com.healthapi.healthapi.controller;

import com.healthapi.healthapi.model.User;
import com.healthapi.healthapi.service.UserServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v0/user")

public class UserController {

    private final UserServicesI userServicesI;

    @Autowired
    public UserController(UserServicesI userServicesI){
        this.userServicesI = userServicesI;
    }

    @GetMapping
    public HashMap<Integer, User> all(){
        return userServicesI.all();
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable("userId") Integer id){
        return userServicesI.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userServicesI.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser (@PathVariable("userId") Integer id, @RequestBody User user){
        return userServicesI.updateUser(id,user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Integer id){
        userServicesI.deleteUser(id);
    }



}
