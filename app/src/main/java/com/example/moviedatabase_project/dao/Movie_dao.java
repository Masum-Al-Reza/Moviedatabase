package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;

@Dao
public interface Movie_dao {
    @Insert
    long insertnewMovie(Movie_pojo movie_pojo);
    @Update
    int UpdatenewMovie(Movie_pojo movie_pojo);
    @Delete
    int DeletenewMovie(Movie_pojo movie_pojo);
}
