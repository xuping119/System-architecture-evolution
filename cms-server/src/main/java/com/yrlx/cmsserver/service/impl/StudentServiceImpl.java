package com.yrlx.cmsserver.service.impl;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.Student;
import com.yrlx.cmsserver.mapper.StudentMapper;
import com.yrlx.cmsserver.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    protected StudentMapper studentMapper;

    @Override
    public List<Student> getStudent() {

        return studentMapper.getStudentTeacher();
    }

    @Override
    public JsonResult getStudent2() {
        JsonResult<List<Student>> result = new JsonResult();
        List<Student> data = studentMapper.getStudentTeacher();
        result.setData(data);
        return result;
    }

    @Override
    public JsonResult getStudent3() {
        JsonResult<List<Student>> result = new JsonResult();
        List<Student> data = studentMapper.getStudentTeacherBySelect();
        result.setData(data);
        return result;
    }


}
