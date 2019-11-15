package com.example.moviedatabase_project.adapter.userl;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedatabase_project.R;

public class Userviewholder extends  RecyclerView.ViewHolder{


    public TextView manage_user_nameTV,manage_user_emailTV,manage_user_passwordTV,manage_user_phoneTV;

    public Userviewholder(@NonNull View itemView) {
        super(itemView);
        manage_user_emailTV=itemView.findViewById(R.id.manage_user_email);
        manage_user_nameTV=itemView.findViewById(R.id.name_manage_user);
        manage_user_passwordTV=itemView.findViewById(R.id.manage_user_password);
        manage_user_phoneTV=itemView.findViewById(R.id.manage_user_number);

    }
}
