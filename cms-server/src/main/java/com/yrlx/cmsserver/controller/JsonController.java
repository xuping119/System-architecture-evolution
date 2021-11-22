package com.yrlx.cmsserver.controller;

import com.yrlx.cmsserver.entity.User;
import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public User getUser(){
        return userService.getUser("test");
    }

    @RequestMapping("/list")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
