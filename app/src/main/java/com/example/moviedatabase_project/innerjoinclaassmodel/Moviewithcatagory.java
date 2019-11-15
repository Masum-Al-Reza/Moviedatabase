package com.example.moviedatabase_project.innerjoinclaassmodel;

import androidx.room.Embedded;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;

public class Moviewithcatagory {
    @Embedded
    public Movie_pojo movie_pojo;
    @Embedded
    public Catagory_pojo catagory_pojo;


}
