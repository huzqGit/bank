package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class Message extends BaseEntity<Integer> {
	private String messageId;// 地址
	private String userId;// 用户姓名
	private String userName;// 用户姓名
	private Date publishDate;// 发布日期
	private String messageContent;// 地址
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	@Override
	public boolean equalsIfIdNull(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int hashCodeIfIdNull() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
