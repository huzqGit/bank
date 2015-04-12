package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerDevice extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7469892461259102070L;
	private String farmerName;
	private String farmerIdNum;
	private String name;
	private String brand;
	private String buyingPrice;
	private Date buyingDate;
	private String assessPrice;
	private String recorder;
	private Date recordTime;
	
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(String buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public Date getBuyingDate() {
		return buyingDate;
	}

	public void setBuyingDate(Date buyingDate) {
		this.buyingDate = buyingDate;
	}

	public String getAssessPrice() {
		return assessPrice;
	}

	public void setAssessPrice(String assessPrice) {
		this.assessPrice = assessPrice;
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
