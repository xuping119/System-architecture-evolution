package com.yrlx.cmsserver.service.impl;

import com.yrlx.cmsserver.common.JsonResult;
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
        //System.out.println(user.toString());
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

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public JsonResult register(User user) {
        JsonResult result = new JsonResult();

        // 验证用户名是否已经注册
        if (haveUser(user.getName())) {
            result.setMsg("该用户名已存在!");
            return result;
        }

        //注册
        if (1 != addUser(user)) {
            result.setMsg("注册失败");
            return result;
        }
        result.setMsg("注册成功");
        return result;
    }

    @Override
    public JsonResult deleteByName(String userName) {
        JsonResult result = new JsonResult();

        // 验证用户名是否已经注册
        if (!haveUser(userName)) {
            result.setMsg("该用户不存在!");
            return result;
        }

        //删除
        userMapper.delUser(userName);
        result.setMsg("删除成功");
        return result;

    }
}
