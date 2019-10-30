package com.example.moviedatabase_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moviedatabase_project.Add_movie_activity;

public class Dashboard_activiity extends AppCompatActivity {
    private CardView addmovieCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activiity);
        addmovieCV=findViewById(R.id.Add_movies_card);
        addmovieCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard_activiity.this, Add_movie_activity.class));
            }
        });


    }


}
