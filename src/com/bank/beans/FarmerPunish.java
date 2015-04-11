package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerPunish extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7374176039416934698L;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdNum;
	//处罚部门
	private String organ;
	//处罚内容
	private String detail;
	//处罚时间
	private Date punishTime;
	//记录人
	private String recorder;
	//记录时间
	private String recordTime;
	

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

	public String getOrgan() {
		return organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getPunishTime() {
		return punishTime;
	}

	public void setPunishTime(Date punishTime) {
		this.punishTime = punishTime;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
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
