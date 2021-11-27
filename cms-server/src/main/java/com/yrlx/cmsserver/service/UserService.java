package com.yrlx.cmsserver.service;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.User;

public interface UserService {

    public JsonResult login(User user);

    public JsonResult register(User user);

    public JsonResult unRegister(User user);
}
