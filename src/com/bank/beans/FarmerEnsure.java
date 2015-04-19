package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerEnsure extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8836401584407097364L;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdNum;
	//被担保人姓名
	private String name;
	//被担保人身份证号
	private String idNum;
	//未结清担保到期日
	private Date limitTime;
	//未结清担保金
	private Double deposit;
	//未结清担保金额合计
	private Double depositAll;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getDepositAll() {
		return depositAll;
	}

	public void setDepositAll(Double depositAll) {
		this.depositAll = depositAll;
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
