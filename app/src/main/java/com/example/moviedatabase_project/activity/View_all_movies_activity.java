package com.example.moviedatabase_project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.adapter.movie.Movie_adapter;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.innerjoinclaassmodel.Moviewithcatagory;

import java.util.List;

public class View_all_movies_activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_all_movies_activity);


    }


}
