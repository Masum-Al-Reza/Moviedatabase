package com.example.moviedatabase_project.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_rating")
public class Rating_pojo {
    @PrimaryKey(autoGenerate = true)
    private long rating_id;
    private long m_id;
    private  long u_id;
    private float rating;
@Ignore
    public Rating_pojo(long rating_id, long m_id, long u_id, float rating) {
        this.rating_id = rating_id;
        this.m_id = m_id;
        this.u_id = u_id;
        this.rating = rating;
    }

    public Rating_pojo(long m_id, long u_id, float rating) {
        this.m_id = m_id;
        this.u_id = u_id;
        this.rating = rating;
    }

    public long getRating_id() {
        return rating_id;
    }

    public void setRating_id(long rating_id) {
        this.rating_id = rating_id;
    }

    public long getM_id() {
        return m_id;
    }

    public void setM_id(long m_id) {
        this.m_id = m_id;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
