package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Movie_pojo;
import com.example.moviedatabase_project.innerjoinclaassmodel.Moviewithcatagory;

import java.util.List;

@Dao
public interface Movie_dao {
    @Insert
    long insertnewMovie(Movie_pojo movie_pojo);
    @Update
    int UpdatenewMovie(Movie_pojo movie_pojo);
    @Delete
    int DeletenewMovie(Movie_pojo movie_pojo);
    @Query("select* from tbl_movie")
    List<Movie_pojo>getallmovies();

@Query("select *from tbl_movie INNEr JOin tbl_catagory on tbl_catagory.cat_id=tbl_movie.m_cat_id")
   List<Moviewithcatagory>getallmoviewithcatagories();
    @Query("select *from tbl_movie INNEr JOin tbl_catagory on tbl_catagory.cat_id=tbl_movie.m_cat_id Where tbl_movie.m_cat_id Like:movie_id")
    Moviewithcatagory getmoviewithcatagories(long movie_id);
    @Query("select * from tbl_movie where m_id Like:movie_id")
    Movie_pojo getuserid(long movie_id);


}
