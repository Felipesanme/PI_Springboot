package com.bookings.bookings.repository;

import com.bookings.bookings.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryDao {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> usersFound = new ArrayList<>();
        userMongoRepository.findAll().forEach(user -> usersFound.add(user));
        return usersFound;
    }

    @Override
    public UserDto findUserById(String idUser) {
        return userMongoRepository.findById(idUser).get();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userMongoRepository.save(userDto);
    }

    @Override
    public boolean updateUser(String idUser, UserDto userDto) {
        UserDto userFound = findUserById(idUser);
        if (userFound != null){
            userFound.setFullName(userDto.getFullName());
            userFound.setEmail(userDto.getEmail());
            userMongoRepository.save(userFound);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUser(String idUser) {
        UserDto userFound = findUserById(idUser);
        if(userFound != null){
            userMongoRepository.delete(userFound);
            return  true;
        }else{
            return false;
        }
    }
}
