package com.example.moviedatabase_project.adapter.userl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.activity.Details_actviity;
import com.example.moviedatabase_project.activity.MainActivity;
import com.example.moviedatabase_project.db.Movie_database;
import com.example.moviedatabase_project.entities.Movie_pojo;
import com.example.moviedatabase_project.entities.User_pojo;

import java.util.ArrayList;
import java.util.List;

public class Useradapter extends RecyclerView.Adapter<Userviewholder> implements Filterable {
    private Context context;
    private List<User_pojo> user_pojos;
    private List<User_pojo> filterableuser_pojos;

    public Useradapter(Context context, List<User_pojo> user_pojos) {
        this.context = context;
        this.user_pojos = user_pojos;
        this.filterableuser_pojos = user_pojos;
    }

    @NonNull
    @Override
    public Userviewholder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.manage_user_details, parent, false);


        return new Userviewholder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull Userviewholder holder, final int position) {
        holder.manage_user_emailTV.setText(filterableuser_pojos.get(position).getU_email());
        holder.manage_user_nameTV.setText(filterableuser_pojos.get(position).getU_name());
        holder.manage_user_passwordTV.setText(filterableuser_pojos.get(position).getU_password());
        holder.manage_user_phoneTV.setText(filterableuser_pojos.get(position).getU_number());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("info").setMessage("are you sure").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        long u_id = user_pojos.get(position).getU_id();
                        User_pojo user = Movie_database.getInstance(context).getuser_dao().getalluserid(u_id);
                        long deleted_row=Movie_database.getInstance(context).getuser_dao().DeletenewUser(user);
                        if (deleted_row>0){
                            user_pojos.remove(user_pojos);
                            notifyDataSetChanged();
                            Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterableuser_pojos.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();


                if (query.isEmpty()) {
                    filterableuser_pojos = user_pojos;

                } else {
                    ArrayList<User_pojo> templist = new ArrayList<>();
                    for (User_pojo u : user_pojos) {
                        if (u.getU_name().contains(query)) {

                            templist.add(u);
                        }
                    }
                    filterableuser_pojos=templist;

                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=filterableuser_pojos;


                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    filterableuser_pojos= (List<User_pojo>) filterResults.values;
         notifyDataSetChanged();   }
        };
    }
}
