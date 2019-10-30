package com.example.moviedatabase_project.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_catagory")
public class Catagory_pojo {
    @PrimaryKey(autoGenerate = true)
    private long cat_id;
    private String cat_name;
@Ignore
    public Catagory_pojo(long cat_id, String cat_name) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
    }

    public Catagory_pojo(String cat_name) {
        this.cat_name = cat_name;
    }

    public long getCat_id() {
        return cat_id;
    }

    public void setCat_id(long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}
