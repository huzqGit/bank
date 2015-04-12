package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerInsured extends BaseEntity<Long> {
	private String farmerName;
	private String farmerIdNum;
	private String name;
	private String type;
	private Double amount;
	private Date insureTime;
	private Date limitTime;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getInsureTime() {
		return insureTime;
	}

	public void setInsureTime(Date insureTime) {
		this.insureTime = insureTime;
	}

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
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
