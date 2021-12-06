package com.yrlx.cmsserver.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Teacher2 {
    private int id;
    private String name;
    private List<Student2> students;

    public Teacher2() {
    }

    public Teacher2(int id, String name, List<Student2> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
