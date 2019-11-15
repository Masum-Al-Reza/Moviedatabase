package com.example.moviedatabase_project.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Comment_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;
import com.example.moviedatabase_project.entities.Rating_pojo;
import com.example.moviedatabase_project.innerjoinclaassmodel.Comment_with_movie_with_user;
import com.example.moviedatabase_project.innerjoinclaassmodel.Rating_with_movie_with_user;

import java.util.List;

@Dao
public interface Comment_dao {
    @Insert
    long insertnewcomment(Comment_pojo comment_pojo);
    @Update
    int Updatenewcomment(Comment_pojo comment_pojo);
    @Delete
    int Deletenewcomment(Comment_pojo comment_pojo);
    @Query("select* from tbl_comment")
    List<Comment_pojo> getallrating();
    @Query("select* from tbl_comment INNER JOIN tbl_movie on tbl_movie.m_cat_id=tbl_comment.comment_m_ids " +
            "INNer JOIN tbl_user on tbl_user.u_id=tbl_comment.comment_u_id")
    List<Comment_with_movie_with_user>getall_Comment_with_movie_with_user();
    @Query("select* from tbl_comment INNER JOIN tbl_movie on tbl_movie.m_cat_id=tbl_comment.comment_m_ids " +
            "INNer JOIN tbl_user on tbl_user.u_id=tbl_comment.comment_u_id Where tbl_comment.coomment_id like:coment_id")
    Comment_with_movie_with_user getall_Comment_with_movie_with_user(long coment_id);


}
