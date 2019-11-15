package com.example.moviedatabase_project.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moviedatabase_project.R;

public class Dashboard_activiity extends AppCompatActivity {
    private CardView addmovieCV,viewallmoviesCV,viewallcatagoriesCV,manageusersCV,pendingcommentsCV,addcatagoriesCV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activiity);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        addmovieCV=findViewById(R.id.Add_movies_card);
        viewallmoviesCV=findViewById(R.id.View_all_moviescard);
        viewallcatagoriesCV=findViewById(R.id.view_all_catagoriescard);
        manageusersCV=findViewById(R.id.manage_users_card);
        pendingcommentsCV=findViewById(R.id.view_pendinf_card);
        addcatagoriesCV=findViewById(R.id.Add_catagories_card);



        addmovieCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard_activiity.this, Add_movie_activity.class));
            }
        });
        viewallmoviesCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard_activiity.this, MainActivity.class));

            }
        });
        viewallcatagoriesCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard_activiity.this, View_all_catagories_activity.class));

            }
        });
        manageusersCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard_activiity.this,Manage_user_activity.class));

            }
        });
        pendingcommentsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard_activiity.this, View_pending_comments_activity.class));

            }
        });
        addcatagoriesCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard_activiity.this, Catagory_activity.class));

            }
        });



    }


}
