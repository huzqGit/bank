package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Message{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4219263116371032409L;
	
	private Long messageid;

	private String userid;

    private String username;

    private String title;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishdate;

    private String content;
    
    private int readnum;
    
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

}