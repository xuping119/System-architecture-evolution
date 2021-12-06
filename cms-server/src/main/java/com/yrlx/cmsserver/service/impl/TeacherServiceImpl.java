package com.yrlx.cmsserver.service.impl;

import com.yrlx.cmsserver.common.JsonResult;
import com.yrlx.cmsserver.entity.Teacher2;
import com.yrlx.cmsserver.mapper.TeacherMapper;
import com.yrlx.cmsserver.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    protected TeacherMapper teacherMapper;

    @Override
    public JsonResult getTeachers(int id) {
        JsonResult<List<Teacher2>> result = new JsonResult();
        List<Teacher2> data = teacherMapper.getTeacherStudents(id);
        result.setData(data);
        return result;
    }
}
