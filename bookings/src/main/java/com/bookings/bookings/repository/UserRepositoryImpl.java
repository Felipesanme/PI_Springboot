package com.bookings.bookings.repository;

import com.bookings.bookings.model.User;
import com.bookings.bookings.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryDao {


    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UserRepositoryImpl(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersFound = new ArrayList<>();
        userMongoRepository.findAll().forEach(user -> usersFound.add(user));
        return usersFound;
    }

    @Override
    public User findUserById(String idUser) {
        Optional<User> userFound = userMongoRepository.findById(idUser);
        if(userFound.isPresent()){
            return userFound.get();
        }else{
            return null;
        }
    }

    @Override
    public User createUser(UserDto userDto) {
        User user =new User(userDto);
        return userMongoRepository.save(user);
    }

    @Override
    public User updateUser(String idUser, UserDto userDto) {
        User userFound = findUserById(idUser);
        if (userFound != null){
            userFound.setFullName(userDto.getFullName());
            userFound.setEmail(userDto.getEmail());
            userFound.setPassword(userDto.getPassword());
            return userMongoRepository.save(userFound);
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteUser(String idUser) {
        User userFound = findUserById(idUser);
        if(userFound != null){
            userMongoRepository.delete(userFound);
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> userFound = userMongoRepository.findByEmail(email);
        if (userFound.isPresent()){
            return userFound.get();
        }else{
            return null;
        }
    }
}
