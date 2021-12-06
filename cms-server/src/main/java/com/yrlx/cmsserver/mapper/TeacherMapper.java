package com.yrlx.cmsserver.mapper;

import com.yrlx.cmsserver.entity.Teacher2;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher2> getTeacherStudents(int id);
}
