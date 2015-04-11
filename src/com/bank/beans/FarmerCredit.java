package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerCredit extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 447074825679634280L;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdNum;
	//信用户评定时间
	private Date assessDate;
	//信用户评定部门
	private String assessOrgan;
	//信用户级别
	private String assessRank;
	//有效期期限
	private String timeLimit;
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

	public Date getAssessDate() {
		return assessDate;
	}

	public void setAssessDate(Date assessDate) {
		this.assessDate = assessDate;
	}

	public String getAssessOrgan() {
		return assessOrgan;
	}

	public void setAssessOrgan(String assessOrgan) {
		this.assessOrgan = assessOrgan;
	}

	public String getAssessRank() {
		return assessRank;
	}

	public void setAssessRank(String assessRank) {
		this.assessRank = assessRank;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
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
