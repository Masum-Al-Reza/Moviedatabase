package com.example.moviedatabase_project.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_comment")
public class Comment_pojo {
    @PrimaryKey(autoGenerate = true)
    private long coomment_id;
    private long m_id;
    private long u_id;
    private String coment;
    private long status;
@Ignore
    public Comment_pojo(long coomment_id, long m_id, long u_id, String coment, long status) {
        this.coomment_id = coomment_id;
        this.m_id = m_id;
        this.u_id = u_id;
        this.coment = coment;
        this.status = status;
    }

    public Comment_pojo(long m_id, long u_id, String coment, long status) {
        this.m_id = m_id;
        this.u_id = u_id;
        this.coment = coment;
        this.status = status;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
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

    public String getComent() {
        return coment;
    }

    public long getCoomment_id() {
        return coomment_id;
    }

    public void setCoomment_id(long coomment_id) {
        this.coomment_id = coomment_id;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }
}
