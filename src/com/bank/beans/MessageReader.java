package com.bank.beans;

import java.util.Date;

public class MessageReader {
    private Long readerid;

    private Long messageid;

    private String userid;

    private String username;

    private Date readtime;

    public Long getReaderid() {
        return readerid;
    }

    public void setReaderid(Long readerid) {
        this.readerid = readerid;
    }

    public Long getMessageid() {
        return messageid;
    }

    public void setMessageid(Long messageid) {
        this.messageid = messageid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getReadtime() {
        return readtime;
    }

    public void setReadtime(Date readtime) {
        this.readtime = readtime;
    }
}