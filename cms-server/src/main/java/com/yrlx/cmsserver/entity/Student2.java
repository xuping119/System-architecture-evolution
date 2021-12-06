package com.yrlx.cmsserver.entity;

import lombok.Getter;
import lombok.Setter;

/*
 * Student2 Teacher2  实现一对多查询
 * */

@Setter
@Getter
public class Student2 {
    private int id;
    private String name;
    private int tid;

    public Student2() {
    }

    public Student2(int id, String name, int tid) {
        this.id = id;
        this.name = name;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                '}';
    }
}
