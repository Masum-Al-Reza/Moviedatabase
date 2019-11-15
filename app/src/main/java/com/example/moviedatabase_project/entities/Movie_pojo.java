package com.example.moviedatabase_project.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_movie")
public class Movie_pojo {
    @PrimaryKey(autoGenerate = true)
    private long m_id;
    private String m_name;

    private long m_cat_id;
    private  String m_year;
    private String image;

@Ignore
    public Movie_pojo(long m_id, String m_name,long m_cat_id, String m_year,String image) {
        this.m_id = m_id;
        this.image=image;
        this.m_name = m_name;
        this.m_cat_id = m_cat_id;
        this.m_year = m_year;

    }

    public Movie_pojo(String m_name, long m_cat_id,String m_year,String image) {
        this.m_name = m_name;
        this.m_cat_id = m_cat_id;
        this.m_year = m_year;
        this.image=image;
    }


    public long getM_id() {
        return m_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setM_id(long m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public long getM_cat_id() {
        return m_cat_id;
    }

    public void setM_cat_id(long m_cat_id) {
        this.m_cat_id = m_cat_id;
    }



    public String getM_year() {
        return m_year;
    }

    public void setM_year(String m_year) {
        this.m_year = m_year;
    }
}
