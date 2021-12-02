package com.yrlx.cmsserver.service;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudent();

    public JsonResult getStudent2();

    public JsonResult getStudent3();
}
