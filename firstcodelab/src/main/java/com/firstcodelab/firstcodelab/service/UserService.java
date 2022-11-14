package com.firstcodelab.firstcodelab.service;
import com.firstcodelab.firstcodelab.data.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class UserService implements UserServiceI{

    HashMap<Integer,User> userInfo = new HashMap<>();

    @Override
    public User createUser(User user) {
        Integer key = user.getId();
        return userInfo.put(key,user);
    }

    @Override
    public User findById(Integer id) {
        return userInfo.get(id);
    }

    @Override
    public HashMap<Integer,User> all() {
        return userInfo;
    }

    @Override
    public void deleteById(Integer id) {
        userInfo.remove(id);
    }

    @Override
    public User update(User user, Integer id) {
        return userInfo.put(id, user);
    }
}
