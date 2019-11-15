package com.example.moviedatabase_project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.adapter.admin.Admin_Adapter;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.innerjoinclaassmodel.Comment_with_movie_with_user;

import java.util.ArrayList;
import java.util.List;

public class View_pending_comments_activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Admin_Adapter admin_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pending_comments_activity);
        recyclerView=findViewById(R.id.comment_recyclerlist);
        List<Comment_with_movie_with_user> comment_with_movie_with_users= Movie_database.getInstance(this).getcomment_dao().getall_Comment_with_movie_with_user();
        admin_adapter=new Admin_Adapter(this,comment_with_movie_with_users);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(admin_adapter);
    }
}
