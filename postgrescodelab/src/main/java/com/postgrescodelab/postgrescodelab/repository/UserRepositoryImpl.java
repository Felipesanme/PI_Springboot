package com.postgrescodelab.postgrescodelab.repository;

import com.postgrescodelab.postgrescodelab.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepositoryDao{

    @Autowired
    UserCrudRepository userCrudRepository;

    @Override
    public UserDto findUserById(Long id) {
        return userCrudRepository.findById(id).get();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userCrudRepository.save(userDto);
    }
}
