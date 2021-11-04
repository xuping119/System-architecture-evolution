package com.yrlx.cmsserver.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @CrossOrigin("*")
    @RequestMapping("/login")
    public String login(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "password",required = false) String password,
            Model model
    ){
        System.out.println("username = " + username + ", password = " + password + ", model = " + model);;
        if (username.equals("123")){
            return "index";
        }else{
            return "login";
        }
    }
}
