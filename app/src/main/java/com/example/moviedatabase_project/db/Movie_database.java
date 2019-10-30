package com.example.moviedatabase_project.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.moviedatabase_project.dao.Catagory_dao;
import com.example.moviedatabase_project.dao.Comment_dao;
import com.example.moviedatabase_project.dao.Movie_dao;
import com.example.moviedatabase_project.dao.Rating_dao;
import com.example.moviedatabase_project.dao.User_dao;
import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Comment_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;
import com.example.moviedatabase_project.entities.Rating_pojo;
import com.example.moviedatabase_project.entities.User_pojo;

@Database(entities = {Catagory_pojo.class, Comment_pojo.class, Movie_pojo.class, Rating_pojo.class, User_pojo.class},version =1 )
public abstract class Movie_database extends RoomDatabase {
private  static  Movie_database db;
public  abstract Catagory_dao getcatagory_dao();
public  abstract Comment_dao getcomment_dao();
public  abstract Movie_dao getmovie_dao();
public  abstract Rating_dao getrating_dao();
public  abstract User_dao getuser_dao();
    public static Movie_database getInstance(Context context){
        if (db==null){
            db= Room.databaseBuilder(context,Movie_database.class,"movie_database")
                    .allowMainThreadQueries().build();
            return db;

        }
        return db;
    }



}
