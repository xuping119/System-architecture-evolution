package com.yrlx.cmsserver.controller;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.User;
import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
        if (userService.haveUser(username)){
            return "index";
        }else{
            return "login";
        }
    }

    @CrossOrigin("*")
    @RequestMapping("/register")
    public JsonResult register(
            @RequestParam(value = "username",required = true) String username,
            @RequestParam(value = "password",required = true) String password
    ){
        JsonResult result = new JsonResult();
//        JSON.parseObject("");
        //校验参数
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            result.setMsg("用户名和密码不能为空");
            return result;
        }

        // 验证用户名是否已经注册
        if (!userService.haveUser(username)) {
            result.setMsg("该用户名已存在!");
            return result;
        }

        //注册
        if (1 != userService.addUser(new User(username,password))) {
            result.setMsg("注册失败");
            return result;
        }
        result.setMsg("注册成功");
        return result;
    }
}
