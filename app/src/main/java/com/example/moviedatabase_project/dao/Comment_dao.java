package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Comment_pojo;

@Dao
public interface Comment_dao {
    @Insert
    long insertnewcomment(Comment_pojo comment_pojo);
    @Update
    int Updatenewcomment(Comment_pojo comment_pojo);
    @Delete
    int Deletenewcomment(Comment_pojo comment_pojo);
}
