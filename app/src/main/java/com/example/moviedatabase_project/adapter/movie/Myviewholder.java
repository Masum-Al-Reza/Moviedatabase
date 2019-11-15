package com.example.moviedatabase_project.adapter.movie;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedatabase_project.R;

public class Myviewholder extends RecyclerView.ViewHolder {
    public TextView NameTv,YeatTv,typetv;
    public ImageView imageshowing;



    public Myviewholder(@NonNull View itemView) {

        super(itemView);

        NameTv=itemView.findViewById(R.id.movie_name_row);
        YeatTv=itemView.findViewById(R.id.movie_year_row);
        typetv=itemView.findViewById(R.id.movie_type_row);
        imageshowing=itemView.findViewById(R.id.imageshowingrecycler);

    }
}
