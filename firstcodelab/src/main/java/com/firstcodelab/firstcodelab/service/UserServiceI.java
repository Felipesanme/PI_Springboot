package com.firstcodelab.firstcodelab.service;

import com.firstcodelab.firstcodelab.data.User;

import java.util.HashMap;
import java.util.List;

public interface UserServiceI {

    HashMap<Integer,User> all();

    User createUser(User user);
    User findById(Integer id);
    void deleteById (Integer id);
    User update(User user, Integer id);


}
