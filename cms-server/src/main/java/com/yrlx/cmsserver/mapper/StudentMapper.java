package com.yrlx.cmsserver.mapper;

import com.yrlx.cmsserver.entity.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> getStudentTeacher();

    public List<Student> getStudentTeacherBySelect();
}
