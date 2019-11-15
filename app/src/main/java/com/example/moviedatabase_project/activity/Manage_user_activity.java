package com.example.moviedatabase_project.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.adapter.userl.Useradapter;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.entities.User_pojo;

import java.util.List;

public class Manage_user_activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Useradapter useradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user_activity);

        recyclerView=findViewById(R.id.manage_user_recycler_list);
        List<User_pojo>user_pojos= Movie_database.getInstance(this).getuser_dao().getalluser();
        useradapter=new Useradapter(this,user_pojos);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(useradapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.user_search,menu);

 SearchView searchView= (SearchView) menu.findItem(R.id.usersearchitem).getActionView();
 searchView.setQueryHint("enter user");
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        useradapter.getFilter().filter(newText);
        return false;
    }
});
        return super.onCreateOptionsMenu(menu);
    }


}
