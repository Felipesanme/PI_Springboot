package com.bookings.bookings.service;

import com.bookings.bookings.model.User;
import com.bookings.bookings.model.UserDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findUserById(String idUser);
    User createUser(UserDto userDto);
    User updateUser(String idUser, UserDto userDto);
    Boolean deleteUser(String idUser);
    User findByEmail(String email);
}

