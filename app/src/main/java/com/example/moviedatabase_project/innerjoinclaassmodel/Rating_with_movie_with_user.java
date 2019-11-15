package com.example.moviedatabase_project.innerjoinclaassmodel;

import androidx.room.Embedded;

import com.example.moviedatabase_project.entities.Movie_pojo;
import com.example.moviedatabase_project.entities.User_pojo;

public class Rating_with_movie_with_user {
    @Embedded
    public Movie_pojo movie_pojo;
    @Embedded
    public User_pojo user_pojo;
}
