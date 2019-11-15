package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;
import com.example.moviedatabase_project.entities.Rating_pojo;
import com.example.moviedatabase_project.innerjoinclaassmodel.Rating_with_movie_with_user;

import java.util.List;

@Dao
public interface Rating_dao {
    @Insert
    long insertnewrating(Rating_pojo rating_pojo);
    @Update
    int Updatenewrating(Rating_pojo rating_pojo);
    @Delete
    int Deletenewrating(Rating_pojo rating_pojo);
    @Query("select* from tbl_rating")
    List<Rating_pojo> getallrating();


    @Query("select* from tbl_rating INNER JOIN tbl_movie on tbl_movie.m_cat_id=tbl_rating.Rating_m_id " +
            "INNer JOIN tbl_user on tbl_user.u_id=tbl_rating.Rating_u_id")
    List<Rating_with_movie_with_user>getallrating_with_movie_with_user();
}
