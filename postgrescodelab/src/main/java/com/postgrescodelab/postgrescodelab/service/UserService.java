package com.postgrescodelab.postgrescodelab.service;

import com.postgrescodelab.postgrescodelab.model.UserDto;

import java.util.List;

public interface UserService {


    UserDto findUserById(Long idUser);
    UserDto createUser(UserDto userDto);

}
