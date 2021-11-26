package com.yrlx.cmsserver.service;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.User;

import java.util.List;

public interface UserService {

    public boolean haveUser(String name);

    public User getUser(String name);

    public List<User> getAllUsers();

    public JsonResult register(User user);

    public JsonResult deleteByName( String userName);
}
