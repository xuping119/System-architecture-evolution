package com.yrlx.cmsserver.entity;

import lombok.Getter;
import lombok.Setter;

/*
* Student Teacher  实现多对一查询
* */

@Setter
@Getter
public class Student {
    private int id;
    private String name;
    private Teacher teacher;

    public Student() {
    }

    public Student(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
