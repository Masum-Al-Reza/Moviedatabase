package com.example.moviedatabase_project.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.adapter.movie.Movie_adapter;
import com.example.moviedatabase_project.db.Movie_database;

import com.example.moviedatabase_project.entities.User_pojo;
import com.example.moviedatabase_project.innerjoinclaassmodel.Moviewithcatagory;
import com.example.moviedatabase_project.sharedpreference.Admin_preference;
import com.example.moviedatabase_project.sharedpreference.Userauthpreferences;
import com.example.moviedatabase_project.sharedpreference.Useridpreferences;
import com.example.moviedatabase_project.user_activity.Login_activity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Movie_adapter movie_adapter;
    private boolean mainstastus;
    private Menu loginM, admin, logout,dashboard;
    private Button canceladmin;
    private User_pojo user_pojo;
    private String adminuser = "admin";
    private String admin_password = "admin";
    private Userauthpreferences userauthpreferences;
    private Admin_preference admin_preference;
    private boolean adminstatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginM = findViewById(R.id.login_menu);

        logout = findViewById(R.id.logout);
        dashboard=findViewById(R.id.admindashboard);



        recyclerView = findViewById(R.id.recyclerViewparent);
        List<Moviewithcatagory> catagories = Movie_database.getInstance(this).getmovie_dao().getallmoviewithcatagories();
        Toast.makeText(this, "size"+catagories.size(), Toast.LENGTH_SHORT).show();
        movie_adapter = new Movie_adapter(this, catagories);


        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(movie_adapter);
        userauthpreferences = new Userauthpreferences(this);
        admin_preference = new Admin_preference(this);
        mainstastus = userauthpreferences.getlognstatus();
        adminstatus = admin_preference.getlognstatus();

        movie_adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.moviesmenu, menu);
        //SearchView searchView= (SearchView) menu.findItem(R.id.itemsearch).getActionView();

        SearchView searchView= (SearchView) menu.findItem(R.id.itemsearch).getActionView();
        searchView.setQueryHint("type movie");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                movie_adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem login = menu.findItem(R.id.login_menu);

        MenuItem logout = menu.findItem(R.id.logout);
        MenuItem dashboard=menu.findItem(R.id.admindashboard);

        if (mainstastus) {
            login.setVisible(false);
            dashboard.setVisible(false);
            logout.setVisible(true);

        } else {
            login.setVisible(true);
            dashboard.setVisible(false);
            logout.setVisible(true);


        }
        if (adminstatus){
            login.setVisible(false);
            dashboard.setVisible(true);
            logout.setVisible(true);

        }else {
            login.setVisible(true);
            dashboard.setVisible(false);
            logout.setVisible(true);

        }


        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login_menu:
                startActivity(new Intent(this, Login_activity.class));


                break;
            case R.id.admindashboard:
                startActivity(new Intent(this, Dashboard_activiity.class));
                break;
            case R.id.logout:
                admin_preference.setloginstatus(false);
                userauthpreferences.setloginstatus(false);
                startActivity(new Intent(this, Login_activity.class));

               break;
        }

        return super.onOptionsItemSelected(item);

    }


}

