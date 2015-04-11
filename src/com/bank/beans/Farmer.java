package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class Farmer extends BaseEntity<Long> {
	private String farmerName;
	private String farmerIdnum;
	private Integer politicStatus;
	private Integer familyNum;
	private String phone;
	private String address;
	private String marryStatus;
	private Integer laborNum;
	private Integer postCode;
	private Double nyNetincome;
	private Double fnNetincome;
	private Double gsNetincome;
	private Double dgNetincome;
	private Double qtNetincome;
	private Double allNetincome;
	private String recorder;
	private Date recordTime;
	
	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(String marryStatus) {
		this.marryStatus = marryStatus;
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

	public Double getNyNetincome() {
		return nyNetincome;
	}

	public void setNyNetincome(Double nyNetincome) {
		this.nyNetincome = nyNetincome;
	}

	public Double getFnNetincome() {
		return fnNetincome;
	}

	public void setFnNetincome(Double fnNetincome) {
		this.fnNetincome = fnNetincome;
	}

	public Double getGsNetincome() {
		return gsNetincome;
	}

	public void setGsNetincome(Double gsNetincome) {
		this.gsNetincome = gsNetincome;
	}

	public Double getDgNetincome() {
		return dgNetincome;
	}

	public void setDgNetincome(Double dgNetincome) {
		this.dgNetincome = dgNetincome;
	}

	public Double getQtNetincome() {
		return qtNetincome;
	}

	public void setQtNetincome(Double qtNetincome) {
		this.qtNetincome = qtNetincome;
	}

	public Double getAllNetincome() {
		return allNetincome;
	}

	public void setAllNetincome(Double allNetincome) {
		this.allNetincome = allNetincome;
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
