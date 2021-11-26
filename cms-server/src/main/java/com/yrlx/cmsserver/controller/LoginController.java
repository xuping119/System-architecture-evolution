package com.yrlx.cmsserver.controller;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.User;
import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private UserService userService;

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

    @RequestMapping("/register")
    public JsonResult register(
            @RequestParam(value = "username",required = true) String username,
            @RequestParam(value = "password",required = true) String password
    ){
        JsonResult result = new JsonResult();

        //校验参数
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            result.setMsg("用户名和密码不能为空");
            return result;
        }

        return userService.register(new User(username,password));
    }

    @RequestMapping("/del")
    public JsonResult deleteByUser(@RequestBody User user){
        JsonResult result = new JsonResult();
        System.out.println(user.toString());
        if (user == null || StringUtils.isEmpty(user.getName())){
            result.setMsg("用户名不能为空");
            return result;
        }

        return  userService.deleteByName(user.getName());
    }
}
