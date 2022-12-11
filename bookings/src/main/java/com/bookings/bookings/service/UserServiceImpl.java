package com.bookings.bookings.service;

import com.bookings.bookings.model.UserDto;
import com.bookings.bookings.repository.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserRepositoryDao{

    @Autowired
    private UserRepositoryDao userRepositoryDao;


    @Override
    public List<UserDto> getAllUsers() {
        return userRepositoryDao.getAllUsers();
    }

    @Override
    public UserDto findUserById(Long idUser) {
        return userRepositoryDao.findUserById(idUser);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userRepositoryDao.createUser(userDto);
    }

    @Override
    public boolean updateUser(Long idUser, UserDto userDto) {
        return userRepositoryDao.updateUser(idUser,userDto);
    }

    @Override
    public boolean deleteUser(Long idUser) {
        return userRepositoryDao.deleteUser(idUser);
    }
}
