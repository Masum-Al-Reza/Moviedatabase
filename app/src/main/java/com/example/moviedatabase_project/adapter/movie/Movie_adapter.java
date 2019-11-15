package com.example.moviedatabase_project.adapter.movie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedatabase_project.R;
import com.example.moviedatabase_project.activity.Details_actviity;
import com.example.moviedatabase_project.innerjoinclaassmodel.Moviewithcatagory;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Movie_adapter extends RecyclerView.Adapter<Myviewholder> implements Filterable {
    Bitmap bmp;
    private Context context;
    private List<Moviewithcatagory> moviewithcatagories;
    private List<Moviewithcatagory> filteredmoviewithcatagories;

    public Movie_adapter(Context context, List<Moviewithcatagory> moviewithcatagories) {
        this.context = context;
        this.moviewithcatagories = moviewithcatagories;
        this.filteredmoviewithcatagories = moviewithcatagories;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemview = inflater.inflate(R.layout.child_recycler_list, parent, false);
        return new Myviewholder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, final int position) {
        holder.NameTv.setText(filteredmoviewithcatagories.get(position).movie_pojo.getM_name());
        holder.YeatTv.setText(filteredmoviewithcatagories.get(position).movie_pojo.getM_year());
        holder.typetv.setText(filteredmoviewithcatagories.get(position).catagory_pojo.getCat_name());
        bmp = BitmapFactory.decodeFile(filteredmoviewithcatagories.get(position).movie_pojo.getImage());
        holder.imageshowing.setImageBitmap(bmp);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long movie_id = filteredmoviewithcatagories.get(position).movie_pojo.getM_id();
                Intent intent = new Intent(context, Details_actviity.class).putExtra("movie_id", movie_id);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredmoviewithcatagories.size();
    }

    public void updatelist(Moviewithcatagory moviewithcatagory) {
        moviewithcatagories.add(moviewithcatagory);
        filteredmoviewithcatagories.add(moviewithcatagory);
        notifyDataSetChanged();


    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();
                if (query.isEmpty()) {
                    filteredmoviewithcatagories = moviewithcatagories;

                } else {
                    ArrayList<Moviewithcatagory> templist = new ArrayList<>();
                    for (Moviewithcatagory m : moviewithcatagories) {
                        if (m.movie_pojo.getM_name().toLowerCase().contains(query) || m.movie_pojo.getM_year().contains(query)) {

                            templist.add(m);
                        }

                    }


                    filteredmoviewithcatagories = templist;

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredmoviewithcatagories;


                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredmoviewithcatagories = (List<Moviewithcatagory>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
