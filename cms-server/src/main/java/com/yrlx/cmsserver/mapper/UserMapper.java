package com.yrlx.cmsserver.mapper;

import com.yrlx.cmsserver.entity.User;

import java.util.List;

public interface UserMapper {
    public User getUser(String name);

    public List<User> getAllUsers();

    public int addUser(User user);
}
