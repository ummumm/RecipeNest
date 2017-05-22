package com.example.richy.newrecipenest;

/**
 * Created by Richy on 5/22/2017.
 */

public class User {
    public String mobile_no, email, password, name;

    public User (String mobile_no,String email,String password,String name) {
        this.mobile_no = mobile_no;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User (String mobile_no,String password) {
        this.mobile_no = mobile_no;
        this.email = "";
        this.password = password;
        this.name = "";
    }

    public User () {
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
