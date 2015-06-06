package com.bank.beans;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Farmer implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7920128196248590259L;
	private Long id;
	private String farmerName;
	private Integer idType; 
	private String farmerIdnum;
	private Integer politicStatus;
	private Integer marryStatus;
	private Integer familyNum;
	private String phone;
	private String villages;
	private String address;
	private Integer sex;
	private Integer education;
	private String occupation;
	private Integer laborNum;
	private Integer postCode;
	private String runitId;
	private String runitName;
	private List<FarmerMember> members;
	private String recorder;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date recordTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getFarmerIdnum() {
		return farmerIdnum;
	}

	public void setFarmerIdnum(String farmerIdnum) {
		this.farmerIdnum = farmerIdnum;
	}

	public Integer getPoliticStatus() {
		return politicStatus;
	}

	public void setPoliticStatus(Integer politicStatus) {
		this.politicStatus = politicStatus;
	}

	public Integer getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(Integer marryStatus) {
		this.marryStatus = marryStatus;
	}

	public Integer getFamilyNum() {
		return familyNum;
	}

	public void setFamilyNum(Integer familyNum) {
		this.familyNum = familyNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getVillages() {
		return villages;
	}

	public void setVillages(String villages) {
		this.villages = villages;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Integer getLaborNum() {
		return laborNum;
	}

	public void setLaborNum(Integer laborNum) {
		this.laborNum = laborNum;
	}

	public Integer getPostCode() {
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	
	public String getRunitId() {
		return runitId;
	}

	public void setRunitId(String runitId) {
		this.runitId = runitId;
	}

	public String getRunitName() {
		return runitName;
	}

	public void setRunitName(String runitName) {
		this.runitName = runitName;
	}
	public List<FarmerMember> getMembers() {
		return members;
	}

	public void setMembers(List<FarmerMember> members) {
		this.members = members;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
