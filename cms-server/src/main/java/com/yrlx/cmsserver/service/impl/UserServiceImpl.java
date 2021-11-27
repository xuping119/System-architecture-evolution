package com.yrlx.cmsserver.service.impl;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.User;
import com.yrlx.cmsserver.mapper.UserMapper;
import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserMapper userMapper;

    public List<User> getAllUsers() {
        List<User> userList = userMapper.getAllUsers();
        return userList;
    }

    @Override
    public JsonResult login(User user) {
        JsonResult result = new JsonResult();
        //查询登录信息
        Map map = new HashMap<String,Object>();
        map.put("name",user.getName());
        map.put("password",user.getPassword());
        if (0 == userMapper.login(map)) {
            result.setMsg("用户名或密码不正确!");
            return result;
        }
        result.setCode("1000");
        result.setMsg("登录成功");
        return result;
    }

    @Override
    public JsonResult register(User user) {
        JsonResult result = new JsonResult();

        // 验证用户名是否已经注册
        if (0 != userMapper.getUser(user.getName())){
            result.setMsg("该用户名已存在!");
            return result;
        }

        //注册
        user.setState(1);
        if (1 != userMapper.addUser(user)) {
            result.setMsg("注册失败");
            return result;
        }
        result.setMsg("注册成功");
        return result;
    }

    @Override
    public JsonResult unRegister(User user) {
        JsonResult result = new JsonResult();

        // 验证用户名是否已经注册
        Map map = new HashMap<String,Object>();
        map.put("name",user.getName());
        map.put("state",1);
        if (0 == userMapper.getUserByState(map)) {
            result.setMsg("该用户不存在或已注销!");
            return result;
        }

        //删除
        userMapper.delUser(user.getName());
        result.setMsg("注销成功");
        return result;

    }
}
