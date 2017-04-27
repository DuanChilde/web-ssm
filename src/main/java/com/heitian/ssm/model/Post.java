package com.heitian.ssm.model;

import java.util.Date;


public class Post {

    private Long id;
    private Long uid;
    private String title;
    private String content;
    private short isAttach;
    private int ctime;
    private int mtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getIsAttach() {
        return isAttach;
    }

    public void setIsAttach(short isAttach) {
        this.isAttach = isAttach;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public int getMtime() {
        return mtime;
    }

    public void setMtime(int mtime) {
        this.mtime = mtime;
    }
}
