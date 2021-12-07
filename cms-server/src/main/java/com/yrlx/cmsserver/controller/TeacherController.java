package com.yrlx.cmsserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @RequestMapping("/getteacher")
    public JsonResult getTeacher(@RequestParam(value = "id")  int id){
        return teacherService.getTeachers(id);
    }

    @RequestMapping("/getteacher2")
    public JsonResult getTeacher2(@RequestBody String jsonParams){

        JSONObject jsonObject = JSON.parseObject(jsonParams);
        int id  = jsonObject.getIntValue("id");
        return teacherService.getTeachers(id);
    }
}
