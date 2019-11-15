package com.example.moviedatabase_project.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_rating")
public class Rating_pojo {
    @PrimaryKey(autoGenerate = true)
    private long rating_id;
    private long Rating_m_id;
    private  long Rating_u_id;
    private float rating;
@Ignore
    public Rating_pojo(long rating_id, long Rating_m_id, long Rating_u_id, float rating) {
        this.rating_id = rating_id;
        this.Rating_m_id = Rating_m_id;
        this.Rating_u_id = Rating_u_id;
        this.rating = rating;
    }

    public Rating_pojo(long Rating_m_id, long Rating_u_id, float rating) {
        this.Rating_m_id = Rating_m_id;
        this.Rating_u_id = Rating_u_id;
        this.rating = rating;
    }

    public long getRating_id() {
        return rating_id;
    }

    public void setRating_id(long rating_id) {
        this.rating_id = rating_id;
    }

    public long getRating_m_id() {
        return Rating_m_id;
    }

    public void setRating_m_id(long Rating_m_id) {
        this.Rating_m_id = Rating_m_id;
    }

    public long getRating_u_id() {
        return Rating_u_id;
    }

    public void setRating_u_id(long Rating_u_id) {
        this.Rating_u_id = Rating_u_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
