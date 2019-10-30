package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.User_pojo;

@Dao
public interface User_dao {
    @Insert
    long insertnewUser(User_pojo user_pojo);
    @Update
    int UpdatenewUser(User_pojo user_pojo);
    @Delete
    int DeletenewUser(User_pojo user_pojo);
}
