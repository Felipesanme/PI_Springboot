package com.bookings.bookings.service;

import com.bookings.bookings.model.User;
import com.bookings.bookings.model.UserDto;
import com.bookings.bookings.repository.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private UserRepositoryDao userRepositoryDao;

    @Autowired
    public UserServiceImpl (UserRepositoryDao userRepositoryDao){
        this.userRepositoryDao = userRepositoryDao;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepositoryDao.getAllUsers();
    }

    @Override
    public User findUserById(String idUser) {
        return userRepositoryDao.findUserById(idUser);
    }

    @Override
    public User createUser(UserDto userDto) {
        return userRepositoryDao.createUser(userDto);
    }

    @Override
    public User updateUser(String idUser, UserDto userDto) {
        return userRepositoryDao.updateUser(idUser,userDto);
    }

    @Override
    public Boolean deleteUser(String idUser) {
        return userRepositoryDao.deleteUser(idUser);
    }

    @Override
    public User findByEmail(String email) {
        return userRepositoryDao.findByEmail(email);
    }
}
