package com.postgrescodelab.postgrescodelab.controller;


import com.postgrescodelab.postgrescodelab.model.UserDto;
import com.postgrescodelab.postgrescodelab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }


}
