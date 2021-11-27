package com.yrlx.cmsserver.controller;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.User;
import com.yrlx.cmsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JsonResult login(@RequestBody User user){
        //System.out.println("username = " + username + ", password = " + password + ", model = " + model);;

        return userService.login(user);
    }

    @RequestMapping("/register")
    public JsonResult register(@RequestBody User user)
       {
        JsonResult result = new JsonResult();

        //校验参数
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            result.setMsg("用户名和密码不能为空");
            return result;
        }

        return userService.register(user);
    }

    @RequestMapping("/unRegister")
    public JsonResult unRegisterByUser(@RequestBody User user){
        JsonResult result = new JsonResult();
        System.out.println(user.toString());
        if (user == null || StringUtils.isEmpty(user.getName())){
            result.setMsg("用户名不能为空");
            return result;
        }

        return  userService.unRegister(user);
    }
}
