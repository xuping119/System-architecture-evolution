package com.yrlx.cmsserver.mapper;

import com.yrlx.cmsserver.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public int getUser(String name);

    public int login(Map map);

    public int getUserByState(Map map);

    public List<User> getAllUsers();

    public int addUser(User user);

    public int delUser(String name);
}
