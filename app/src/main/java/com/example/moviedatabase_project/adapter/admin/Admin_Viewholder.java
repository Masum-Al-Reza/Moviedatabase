package com.example.moviedatabase_project.adapter.admin;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedatabase_project.R;

public class Admin_Viewholder extends RecyclerView.ViewHolder {

    public TextView coomenrsTV,nameTV;



    public Admin_Viewholder(@NonNull View itemView) {
        super(itemView);
     coomenrsTV=itemView.findViewById(R.id.name_row_comments);
     nameTV=itemView.findViewById(R.id.comments_row);
    }
}
