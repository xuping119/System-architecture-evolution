package com.yrlx.cmsserver.service.impl;

import com.yrlx.cmsserver.entity.User;
import com.yrlx.cmsserver.mapper.UserMapper;
import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserMapper userMapper;

    @Override
    public boolean checkUser(String name) {
        User user = userMapper.checkUser(name);
        if (user == null){
            return false;
        }
        return true;
    }
}
