package com.bookings.bookings.repository;

import com.bookings.bookings.model.UserDto;

import java.util.List;

public interface UserRepositoryDao {
    List<UserDto> getAllUsers();
    UserDto findUserById(Long idUser);
    UserDto createUser(UserDto userDto);
    boolean updateUser(Long idUser, UserDto userDto);
    boolean deleteUser(Long idUser);

}
