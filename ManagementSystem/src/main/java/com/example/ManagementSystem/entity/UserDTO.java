package com.example.ManagementSystem.entity;


import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class UserDTO {

    @NotEmpty(message = "The name is required")
    private String user_name;

    @NotEmpty(message = "The password is required")
    private String user_pswd;

    @NotEmpty(message = "The role is required")
    private String is_admin;

    @NotEmpty(message = "The email is required")
    private String email;
    private String phone_num;
    private Date crt_dt_ts;

    public Date getCrt_dt_ts() {
        return crt_dt_ts;
    }

    public void setCrt_dt_ts(Date crt_dt_ts) {
        this.crt_dt_ts = crt_dt_ts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name( String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pswd() {
        return user_pswd;
    }

    public void setUser_pswd( String user_pswd) {
        this.user_pswd = user_pswd;
    }

}
