package com.bookings.bookings.repository;

import com.bookings.bookings.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<UserDto> userFound = userMongoRepository.findById(idUser);
        if(userFound.isPresent()){
            return userFound.get();
        }else{
            return null;
        }
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
            userFound.setIdUser(userDto.getIdUser());
            userFound.setPassword(userDto.getPassword());
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

    @Override
    public UserDto findByEmail(String email) {
        Optional<UserDto> userFound = userMongoRepository.findByEmail(email);
        if (userFound.isPresent()){
            return userFound.get();
        }else{
            return null;
        }
    }
}
