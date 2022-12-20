package com.bookings.bookings.repository;

import com.bookings.bookings.model.UserDto;

import java.util.List;

public interface UserRepositoryDao {
    List<UserDto> getAllUsers();
    UserDto findUserById(String idUser);
    UserDto createUser(UserDto userDto);
    boolean updateUser(String idUser, UserDto userDto);
    boolean deleteUser(String idUser);
    UserDto findByEmail(String email);

}
