package com.bank.beans;

import com.common.bean.BaseEntity;

public class FarmerMember extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1550305454462009720L;
	//农户姓名
	private String farmerName;
	//农户的身份证号
	private String farmerIdNum;
	//家庭成员姓名
	private String name;
	//家庭成员与户主关系
	private String relation;
	//家庭成员的身份证号
	private String idNum;
	//家庭成员的文化程度
	private Integer education;
	//家庭成员的婚姻状况
	private String marryStatus;
	//家庭成员的职业
	private String occupation;
	//家庭成员的职务
	private String job;
	//家庭成员的性别
	private Integer sex;
	//家庭成员的联系电话
	private String phone;
	
	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmerIdNum() {
		return farmerIdNum;
	}

	public void setFarmerIdNum(String farmerIdNum) {
		this.farmerIdNum = farmerIdNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(String marryStatus) {
		this.marryStatus = marryStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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