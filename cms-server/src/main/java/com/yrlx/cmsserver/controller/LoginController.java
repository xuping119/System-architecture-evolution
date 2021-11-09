package com.yrlx.cmsserver.controller;

import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin("*")
    @RequestMapping("/login")
    public String login(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "password",required = false) String password,
            Model model
    ){
        System.out.println("username = " + username + ", password = " + password + ", model = " + model);;
        if (userService.checkUser(username)){
            return "index";
        }else{
            return "login";
        }
    }
}
