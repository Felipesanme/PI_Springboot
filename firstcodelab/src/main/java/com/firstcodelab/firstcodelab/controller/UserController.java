package com.firstcodelab.firstcodelab.controller;

import com.firstcodelab.firstcodelab.data.User;
import com.firstcodelab.firstcodelab.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserServiceI userServiceI;

    @Autowired
    public UserController(UserServiceI userServiceI){
        this.userServiceI = userServiceI;
    }
    @GetMapping
    public HashMap<Integer, User> all(){
       return userServiceI.all();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userServiceI.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userServiceI.createUser(user);
    }


    @PutMapping ("/{id}")
    public User update (@PathVariable("id") Integer id,@RequestBody User user){
        return userServiceI.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userServiceI.deleteById(id);
    }


}
