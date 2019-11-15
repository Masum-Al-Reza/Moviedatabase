package com.example.moviedatabase_project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.entities.Catagory_pojo;


public class Catagory_activity extends AppCompatActivity {

private EditText addact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addact=findViewById(R.id.catagoryadd);
        setContentView(R.layout.activity_catagory_activity);



    }


    public void addcat(View view) {
        String catagory=addact.getText().toString();
        Catagory_pojo catagory_pojo=new Catagory_pojo(catagory);
        long insertcatagoryrow= Movie_database.getInstance(this).getcatagory_dao().insertnewcatagory(catagory_pojo);
        if (insertcatagoryrow>0){
            startActivity(new Intent(this,Dashboard_activiity.class));
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();

        }else

            Toast.makeText(this, "files", Toast.LENGTH_SHORT).show();


    }
}
