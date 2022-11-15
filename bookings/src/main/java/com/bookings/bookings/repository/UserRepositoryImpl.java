package com.bookings.bookings.repository;

import com.bookings.bookings.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryDao {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> usersFound = new ArrayList<>();
        userCrudRepository.findAll().forEach(user -> usersFound.add(user));
        return usersFound;
    }

    @Override
    public UserDto findUserById(Long idUser) {
        return userCrudRepository.findById(idUser).get();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userCrudRepository.save(userDto);
    }

    @Override
    public boolean updateUser(Long idUser, UserDto userDto) {
        UserDto userFound = findUserById(idUser);
        if (userFound != null){
            userFound.setFullName(userDto.getFullName());
            userFound.setEmail(userDto.getEmail());
            userCrudRepository.save(userFound);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long idUser) {
        UserDto userFound = findUserById(idUser);
        if(userFound != null){
            userCrudRepository.delete(userFound);
            return  true;
        }else{
            return false;
        }
    }
}
