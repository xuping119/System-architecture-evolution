package com.yrlx.cmsserver.controller;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.Student;
import com.yrlx.cmsserver.service.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/getsudent")
    public List<Student> getAllStudents(){
        return studentService.getStudent();
    }

    @RequestMapping("/getsudent2")
    public JsonResult getAllStudents2(){
        return studentService.getStudent2();
    }

    @RequestMapping("/getsudent3")
    public JsonResult getAllStudents3(){
        return studentService.getStudent3();
    }
}
