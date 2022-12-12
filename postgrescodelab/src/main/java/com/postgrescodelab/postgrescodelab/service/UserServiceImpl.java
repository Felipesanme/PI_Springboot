package com.postgrescodelab.postgrescodelab.service;

import com.postgrescodelab.postgrescodelab.model.UserDto;
import com.postgrescodelab.postgrescodelab.repository.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositoryDao userRepository;
    @Override
    public UserDto findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userRepository.createUser(userDto);
    }
}
