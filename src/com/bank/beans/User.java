package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class User extends BaseEntity<Integer> {
	private String userId;// 用户姓名
	private String userName;// 用户姓名
	private String password;// 地址
	private String sex;// 性别
	private Date birthday;// 出生日期
	private String address;// 地址
	private String organId;// 地址
	private String unitId;
	private String isAdmin;
	private Organ unit;
	private int remindCycle;
	private Date remindDate;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public Organ getUnit() {
		return unit;
	}
	public void setUnit(Organ unit) {
		this.unit = unit;
	}
	public int getRemindCycle() {
		return remindCycle;
	}
	public void setRemindCycle(int remindCycle) {
		this.remindCycle = remindCycle;
	}
	public Date getRemindDate() {
		return remindDate;
	}
	public void setRemindDate(Date remindDate) {
		this.remindDate = remindDate;
	}
	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}
	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}
	
}
