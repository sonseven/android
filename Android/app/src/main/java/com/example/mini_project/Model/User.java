package com.example.mini_project.Model;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private String fullname;
    private String birth;

    public User() {
    }

    public User(String username, String password, String fullname, String birth) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.birth = birth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }


}
