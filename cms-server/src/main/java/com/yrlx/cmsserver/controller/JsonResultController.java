package com.yrlx.cmsserver.controller;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.User;
import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jsonresult")
public class JsonResultController {
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public JsonResult<User> getUser(){
        return new JsonResult<>(userService.getUser("test"));
    }

    @RequestMapping("/list")
    public JsonResult<List> getAllUsers(){
        return new JsonResult<>(userService.getAllUsers());
    }
}
