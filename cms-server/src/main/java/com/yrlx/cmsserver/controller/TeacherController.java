package com.yrlx.cmsserver.controller;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.service.TeacherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
