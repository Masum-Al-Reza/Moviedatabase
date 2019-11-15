package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;

import java.util.List;

@Dao
public interface Catagory_dao {
    @Insert
    long insertnewcatagory(Catagory_pojo catagory_pojo);
    @Update
    int Updatenewcatagory(Catagory_pojo catagory_pojo);
    @Delete
    int Deletenewcatagory(Catagory_pojo catagory_pojo);
    @Query("select * from tbl_catagory where cat_id like :cat_id")
    Catagory_pojo getcatagoryById(long cat_id);
    @Query("select* from tbl_catagory")
    List<Catagory_pojo> getallcatagory();




}
