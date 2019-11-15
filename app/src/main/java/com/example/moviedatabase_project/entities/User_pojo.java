package com.example.moviedatabase_project.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "tbl_user")
public class User_pojo {
    @PrimaryKey(autoGenerate = true)
    private long u_id;
    private String u_name;
    private String u_number;
    private String u_email;
    private String u_password;

@Ignore
    public User_pojo(long u_id, String u_name, String u_number, String u_email, String u_password) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_number = u_number;
        this.u_email = u_email;
        this.u_password = u_password;
    }


    public User_pojo(String u_name, String u_number, String u_email, String u_password) {
        this.u_name = u_name;
        this.u_number = u_number;
        this.u_email = u_email;
        this.u_password = u_password;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_number() {
        return u_number;
    }

    public void setU_number(String u_number) {
        this.u_number = u_number;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }
}
