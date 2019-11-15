package com.example.moviedatabase_project.user_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.activity.Dashboard_activiity;
import com.example.moviedatabase_project.activity.MainActivity;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.sharedpreference.Admin_preference;
import com.example.moviedatabase_project.sharedpreference.Userauthpreferences;
import com.example.moviedatabase_project.sharedpreference.Useridpreferences;

public class Login_activity extends AppCompatActivity {
    private EditText login, password;
    private Userauthpreferences userauthpreferences;
    private Useridpreferences useridpreferences;
    private Admin_preference admin_preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        login = findViewById(R.id.username_email_input);
        password = findViewById(R.id.password_input);
        final TextView register = findViewById(R.id.register);
        useridpreferences=new Useridpreferences(this);
        admin_preference=new Admin_preference(this);
        boolean admin=admin_preference.getlognstatus();
        if (admin) {
            startActivity(new Intent(this,Dashboard_activiity.class));


        }

        userauthpreferences = new Userauthpreferences(this);
        boolean statuse = userauthpreferences.getlognstatus();
        if (statuse) {
          startActivity(new Intent(this,MainActivity.class));

        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_activity.this, Authentication.class));
            }
        });
    }


    public void logged(View view) {
        String username = login.getText().toString();
        String pass = password.getText().toString();
        long id = Movie_database.getInstance(this).getuser_dao().getId(username, pass);
        if (id > 0) {
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            useridpreferences.setLogin(id);
            userauthpreferences.setloginstatus(true);
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }else {
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        }


          if (username.equals("admin") && pass.equals("admin")){
                admin_preference.setloginstatus(true);

                startActivity(new Intent(this, Dashboard_activiity.class));
        }

    }
}