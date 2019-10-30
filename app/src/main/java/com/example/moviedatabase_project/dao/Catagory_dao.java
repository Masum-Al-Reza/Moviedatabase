package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;

@Dao
public interface Catagory_dao {
    @Insert
    long insertnewcatagory(Catagory_pojo catagory_pojo);
    @Update
    int Updatenewcatagory(Catagory_pojo catagory_pojo);
    @Delete
    int Deletenewcatagory(Catagory_pojo catagory_pojo);




}
