package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerUnbalanced extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2453654101383750646L;
	private String farmerName;
	private String farmerIdNum;
	private Integer bank;
	private Integer businessType;
	private String loanUse;
	private Integer loanWay;
	private	Double loanBalance;
	private Date provideTime;
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

	public Integer getBank() {
		return bank;
	}

	public void setBank(Integer bank) {
		this.bank = bank;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public String getLoanUse() {
		return loanUse;
	}

	public void setLoanUse(String loanUse) {
		this.loanUse = loanUse;
	}

	public Integer getLoanWay() {
		return loanWay;
	}

	public void setLoanWay(Integer loanWay) {
		this.loanWay = loanWay;
	}

	public Double getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(Double loanBalance) {
		this.loanBalance = loanBalance;
	}

	public Date getProvideTime() {
		return provideTime;
	}

	public void setProvideTime(Date provideTime) {
		this.provideTime = provideTime;
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
