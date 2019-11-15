package com.example.moviedatabase_project.user_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.activity.MainActivity;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.entities.User_pojo;
import com.example.moviedatabase_project.sharedpreference.Userauthpreferences;
import com.example.moviedatabase_project.sharedpreference.Useridpreferences;

public class Authentication extends AppCompatActivity {
    private EditText usernameET,emailET,phonenumberET,passwordET,password2ET;
    private Userauthpreferences userauthpreferences;
   private Useridpreferences useridpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        usernameET=findViewById(R.id.Usernameinput);
        emailET=findViewById(R.id.emailaddressinput);
        phonenumberET=findViewById(R.id.phonenumberinput);
        passwordET=findViewById(R.id.password1input);
        password2ET=findViewById(R.id.password2input);
        userauthpreferences= new Userauthpreferences(this);
       useridpreferences= new Useridpreferences(this);
    }

    public void register(View view) {
        String name=usernameET.getText().toString();
        String email=emailET.getText().toString();
        String phonenumber=phonenumberET.getText().toString();
        String password1=passwordET.getText().toString();
        String password2=password2ET.getText().toString();



        if (password1.equals(password2)){
            User_pojo user=new User_pojo(name,phonenumber,email,password1);

            long users=Movie_database.getInstance(this).getuser_dao().insertnewUser(user);
           long id = Movie_database.getInstance(this).getuser_dao().getId(name,password1);



            if (users>0 && id>0){
                Toast.makeText(this, "registered", Toast.LENGTH_SHORT).show();


                userauthpreferences.setloginstatus(true);
                useridpreferences.setLogin(id);
                startActivity(new Intent(this, MainActivity.class));

            }
        }else{
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        }




    }
}
