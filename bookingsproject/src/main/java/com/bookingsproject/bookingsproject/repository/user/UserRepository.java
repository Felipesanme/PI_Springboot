package com.bookingsproject.bookingsproject.repository.user;

import com.bookingsproject.bookingsproject.dto.user.UserDto;
import com.bookingsproject.bookingsproject.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();
    User findById(String id);
    User createUser(UserDto userDto);
    User updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
    User findByEmail(String email);
}
