package Model;

import java.util.Date;

public class User {
    private String userName;
    private String password;
    private String birthday;
    private String name;

    public User() {
    }

    public User(String userName, String password, String birthday, String name){
        this.userName=userName;
        this.password= password;
        this.birthday= birthday;
        this.name=name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
