package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;
import com.example.moviedatabase_project.entities.User_pojo;

import java.util.List;

@Dao
public interface User_dao {
    @Insert
    long insertnewUser(User_pojo user_pojo);
    @Update
    int UpdatenewUser(User_pojo user_pojo);
    @Delete
    int DeletenewUser(User_pojo user_pojo);
    @Query("select* from tbl_user")
    List<User_pojo> getalluser();
    @Query("select u_id from tbl_user where u_name=:name and u_password=:pass")
    long  getId(String name,String pass);
    @Query("select * from tbl_user where u_id Like:u_id")
    User_pojo getalluserid(long u_id);

}
