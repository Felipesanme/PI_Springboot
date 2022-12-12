package com.postgrescodelab.postgrescodelab.repository;

import com.postgrescodelab.postgrescodelab.model.UserDto;

public interface UserRepositoryDao {

    UserDto findUserById(Long id);
    UserDto createUser(UserDto userDto);
}
