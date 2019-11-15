package com.example.moviedatabase_project.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_comment")
public class Comment_pojo {
    @PrimaryKey(autoGenerate = true)
    private long coomment_id;
    private long comment_m_ids;
    private long comment_u_id;
    private String coment;
    private long status;
@Ignore
    public Comment_pojo(long coomment_id, long comment_m_ids, long comment_u_id, String coment, long status) {
        this.coomment_id = coomment_id;
        this.comment_m_ids = comment_m_ids;
        this.comment_u_id = comment_u_id;
        this.coment = coment;
        this.status = status;
    }

    public Comment_pojo(long comment_m_ids, long comment_u_id, String coment, long status) {
        this.comment_m_ids = comment_m_ids;
        this.comment_u_id = comment_u_id;
        this.coment = coment;
        this.status = status;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getComment_m_ids() {
        return comment_m_ids;
    }

    public void setComment_m_ids(long comment_m_ids) {
        this.comment_m_ids = comment_m_ids;
    }

    public long getComment_u_id() {
        return comment_u_id;
    }

    public void setComment_u_id(long comment_u_id) {
        this.comment_u_id = comment_u_id;
    }

    public long getcomment_u_id() {
        return comment_u_id;
    }

    public void setcomment_u_id(long comment_u_id) {
        this.comment_u_id = comment_u_id;
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
