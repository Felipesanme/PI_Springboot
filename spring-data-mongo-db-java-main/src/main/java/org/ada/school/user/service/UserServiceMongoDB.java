package org.ada.school.user.service;

import org.ada.school.user.controller.dto.UserDto;
import org.ada.school.user.model.User;
import org.ada.school.user.repository.UserDocument;
import org.ada.school.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongoDB implements UserService{

    private final UserRepository userRepository;


    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }
    @Override
    public User create(UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDocument> all() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        return userRepository.deleteById(id);
    }

    @Override
    public User update(UserDto userDto, String id) {
        return userRepository.update(userDto,id);
    }
}
