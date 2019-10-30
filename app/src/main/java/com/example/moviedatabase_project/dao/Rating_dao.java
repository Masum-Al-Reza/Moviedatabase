package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Rating_pojo;

@Dao
public interface Rating_dao {
    @Insert
    long insertnewrating(Rating_pojo rating_pojo);
    @Update
    int Updatenewrating(Rating_pojo rating_pojo);
    @Delete
    int Deletenewrating(Rating_pojo rating_pojo);
}
