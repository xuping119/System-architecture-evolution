package com.yrlx.cmsserver.service.impl;

import com.yrlx.cmsserver.entity.User;
import com.yrlx.cmsserver.mapper.UserMapper;
import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserMapper userMapper;

    @Override
    public boolean haveUser(String name) {
        User user = userMapper.getUser(name);
        if (user == null){
            return false;
        }
        return true;
    }

    @Override
    public User getUser(String name) {
        User user = userMapper.getUser(name);
        if (user != null){
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userMapper.getAllUsers();
        return userList;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
