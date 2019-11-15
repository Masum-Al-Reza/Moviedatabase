package com.example.moviedatabase_project.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.entities.Catagory_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;

import java.util.ArrayList;
import java.util.List;

public class Add_movie_activity extends AppCompatActivity {
    private static final int REQUEST_STORAGE_PERMSIONCODE_CODE = 123;
    private static final int GALLERY_REQUEST_CODE = 456;
    private EditText NameET, YearET;
    private Spinner moviespinner;
    private String catid = "";
    private List<Catagory_pojo> Catagorylist = new ArrayList<>();
    private String imagePath;
    private ImageView CourseImages;
    private Button save,update;
    private long movie_id=0;
    private String catagories="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_movie_activity);
        NameET = findViewById(R.id.Moviename_input);
        YearET = findViewById(R.id.yearinput);
        moviespinner = findViewById(R.id.MovieSpinner);
        CourseImages = findViewById(R.id.Courseimage);
        save=findViewById(R.id.savebt);
        update=findViewById(R.id.updatebt);
       Loadspinner();
       moviespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              catagories= adapterView.getItemAtPosition(i).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

        movie_id=getIntent().getLongExtra("movie_id",-1);
        if(movie_id>0){
            Movie_pojo user=Movie_database.getInstance(this).getmovie_dao().getuserid(movie_id);
            NameET.setText(user.getM_name());
            YearET.setText(user.getM_year());

            save.setVisibility(View.INVISIBLE);
            update.setVisibility(View.VISIBLE);


        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] projection = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(data.getData(), projection, null, null, null);
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(projection[0]);
            imagePath = cursor.getString(index);

            Bitmap bmp = BitmapFactory.decodeFile(imagePath);
            CourseImages.setImageBitmap(bmp);

        }

    }

    public void gotomain(View view) {
        String name = NameET.getText().toString();
        String year = YearET.getText().toString();
        String movie=catagories;

        Catagory_pojo cat = new Catagory_pojo(movie);
        long insertedcat = Movie_database.getInstance(this).getcatagory_dao().insertnewcatagory(cat);

             if (insertedcat > 0) {
            Movie_pojo movie_pojos = new Movie_pojo(name, insertedcat,year, imagePath);
            long insertedmoviesid = Movie_database.getInstance(this).getmovie_dao().insertnewMovie(movie_pojos);

            if (insertedmoviesid > 0) {
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
            }


        }


    }

    public void selectimage(View view) {
        if (IsStroagePermissionAccept()) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST_CODE);
        }
    }
    private  void Loadspinner(){

        Catagorylist = Movie_database.getInstance(this).getcatagory_dao().getallcatagory();
        List<String> Catagoryname = new ArrayList<>();
        Catagoryname.add("Action");
        Catagoryname.add("thriller");
        Catagoryname.add("Drama");
        Catagoryname.add("Romantic");
        for (Catagory_pojo c : Catagorylist) {
            Catagoryname.add(c.getCat_name());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Catagoryname);
        moviespinner.setAdapter(adapter);

    }

    private boolean IsStroagePermissionAccept() {
        String[] permsionlist = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permsionlist, REQUEST_STORAGE_PERMSIONCODE_CODE);
            return false;
        }
        return true;
    }

    public void update(View view) {

            String name = NameET.getText().toString();
            String year = YearET.getText().toString();
            String movie=catagories;
            Catagory_pojo cat=new Catagory_pojo(movie);
            long uodatedcat=Movie_database.getInstance(this).getcatagory_dao().Updatenewcatagory(cat);

            Toast.makeText(this, "buttoncliccked", Toast.LENGTH_SHORT).show();

                Movie_pojo movie_pojos = new Movie_pojo(name,uodatedcat, year, imagePath);
                Toast.makeText(this, "catagory", Toast.LENGTH_SHORT).show();
                final long insertedmoviesid = Movie_database.getInstance(this).getmovie_dao().UpdatenewMovie(movie_pojos);

                if (insertedmoviesid > 0) {
                    startActivity(new Intent(this, MainActivity.class));
                    Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
                }


            }


        }


