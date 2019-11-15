package com.example.moviedatabase_project.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.adapter.admin.Admin_Adapter;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.entities.Comment_pojo;
import com.example.moviedatabase_project.entities.Movie_pojo;
import com.example.moviedatabase_project.entities.User_pojo;
import com.example.moviedatabase_project.innerjoinclaassmodel.Comment_with_movie_with_user;
import com.example.moviedatabase_project.innerjoinclaassmodel.Moviewithcatagory;
import com.example.moviedatabase_project.sharedpreference.Admin_preference;
import com.example.moviedatabase_project.sharedpreference.Userauthpreferences;

import org.w3c.dom.Comment;

import java.util.List;

public class Details_actviity extends AppCompatActivity {
    private ImageView showdetailsImage;
    private TextView namedetailTV, YeardetailsTV, TYpeDEtailsTV;
    private RatingBar ratingRT;
    private Userauthpreferences userauthpreferences;
    long movie_id = 0;
    long User_id = 0;
    private Button update,delete;
    private boolean adminstatus;
    private EditText comments;
    long comment_id=0;
    Bitmap bmp;
    private Admin_preference admin_preference;
    private RecyclerView recyclerView;
  //  private Admin_Adapter admin_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_actviity);
        showdetailsImage = findViewById(R.id.details_image);
        namedetailTV = findViewById(R.id.name_details);
        comments=findViewById(R.id.commentsET);
        update=findViewById(R.id.updateuserlist);
        delete=findViewById(R.id.deleteUSerli);
        YeardetailsTV = findViewById(R.id.year_details);
        ratingRT = findViewById(R.id.ratingBar);
        recyclerView=findViewById(R.id.comment_recyclerlist);
        userauthpreferences= new Userauthpreferences(this);
        admin_preference=new Admin_preference(this);
        adminstatus=admin_preference.getlognstatus();
        if (adminstatus){
            update.setVisibility(View.VISIBLE);
            delete.setVisibility(View.VISIBLE);

         }else {

             update.setVisibility(View.INVISIBLE);
            delete.setVisibility(View.INVISIBLE);
        }
       /* List<Comment_with_movie_with_user>comment_with_movie_with_users=Movie_database.getInstance(this).getcomment_dao().getall_Comment_with_movie_with_user();
        LinearLayoutManager llm= new  LinearLayoutManager(this);
        admin_adapter=new Admin_Adapter(this,comment_with_movie_with_users);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(admin_adapter);*/
        TYpeDEtailsTV = findViewById(R.id.type_details);
        movie_id = getIntent().getLongExtra("movie_id", -1);
        User_id=getIntent().getLongExtra("u_id",-1);
        if (movie_id > 0) {
            Moviewithcatagory moviewithcatagory = Movie_database.getInstance(this).getmovie_dao().getmoviewithcatagories(movie_id);
            namedetailTV.setText(moviewithcatagory.movie_pojo.getM_name());
            bmp = BitmapFactory.decodeFile(moviewithcatagory.movie_pojo.getImage());
            showdetailsImage.setImageBitmap(bmp);
            YeardetailsTV.setText(moviewithcatagory.movie_pojo.getM_year());
            TYpeDEtailsTV.setText(moviewithcatagory.catagory_pojo.getCat_name());


        }


    }

    public void deletelist(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("info").setMessage("are you sure u want to delete").setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Movie_pojo user = Movie_database.getInstance(Details_actviity.this).getmovie_dao().getuserid(movie_id);
                Movie_database.getInstance(Details_actviity.this).getmovie_dao().DeletenewMovie(user);

                long movie_id = user.getM_id();

                Intent intent = new Intent(Details_actviity.this, MainActivity.class);
                intent.putExtra("movie_id", movie_id);
                Details_actviity.this.startActivity(intent);
                Toast.makeText(Details_actviity.this, "deleted", Toast.LENGTH_SHORT).show();


            }

        }).setNegativeButton("no", null);
        final AlertDialog dialog = builder.create();
        dialog.show();

    }


    public void updatelist(View view) {
        Movie_pojo user=Movie_database.getInstance(this).getmovie_dao().getuserid(movie_id);
        long movie_id=user.getM_id();
        Intent intent=new Intent(this,Add_movie_activity.class);
        intent.putExtra("movie_id",movie_id);
        this.startActivity(intent);
    }

    public void comments(View view) {
           String com=comments.getText().toString();
           long status=0;
           long movieid=movie_id;
           long userid=User_id;

           Comment_pojo comment_pojo=new Comment_pojo(movieid,userid,com,status);
           long commented=Movie_database.getInstance(this).getcomment_dao().insertnewcomment(comment_pojo);
           if(commented>0) {
               Movie_pojo movie = Movie_database.getInstance(this).getmovie_dao().getuserid(movie_id);
               long moviid=movie.getM_id();

              /* if (moviid>0){
                   User_pojo user_pojo=Movie_database.getInstance(this).getuser_dao().getalluserid(User_id);
                   long userr=user_pojo.getU_id();*/
                   if (moviid>0){
                       Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
                   }


               }
           }
        User_pojo user=Movie_database.getInstance(this).getuser_dao().getalluserid(User_id);
    }

