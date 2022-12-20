package com.bookings.bookings.service;

import com.bookings.bookings.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto findUserById(String idUser);
    UserDto createUser(UserDto userDto);
    boolean updateUser(Long idUser, UserDto userDto);
    boolean deleteUser(Long idUser);
    UserDto findByEmail(String email);
}

