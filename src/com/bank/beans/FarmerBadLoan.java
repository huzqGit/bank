package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerBadLoan extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5033933367262200284L;
	private String farmerName;
	private String farmerIdNum;
	private String bank;
	private Double balance;
	private Date paymentTime;
	//记录人
	private String recorder;
	//记录时间
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
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
