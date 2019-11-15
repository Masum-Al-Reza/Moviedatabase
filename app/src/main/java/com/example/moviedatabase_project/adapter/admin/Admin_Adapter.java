package com.example.moviedatabase_project.adapter.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.adapter.movie.Myviewholder;
import com.example.moviedatabase_project.innerjoinclaassmodel.Comment_with_movie_with_user;

import java.util.List;

public class Admin_Adapter extends RecyclerView.Adapter<Admin_Viewholder> {
    private Context context;
    private List<Comment_with_movie_with_user>comment_with_movie_with_users;

    public Admin_Adapter(Context context, List<Comment_with_movie_with_user> comment_with_movie_with_users) {
        this.context = context;
        this.comment_with_movie_with_users = comment_with_movie_with_users;
    }

    @NonNull
    @Override
    public Admin_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemview=inflater.inflate(R.layout.comments_row_child,parent,false);
        return new Admin_Viewholder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Admin_Viewholder holder, int position) {
        holder.coomenrsTV.setText(comment_with_movie_with_users.get(position).comment_pojo.getComent());


    }

    @Override
    public int getItemCount() {
        return comment_with_movie_with_users.size();
    }
}
