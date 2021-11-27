package com.yrlx.cmsserver.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String password;
    private int state;

    public User() {
        id = 0;
        name = "";
        password = "";
        state =0;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        state = 0;
    }

    public User(String name, int state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                '}';
    }
}
