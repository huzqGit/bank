package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerIncome extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3001805087077814968L;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdnum;
	//收入项目名称
	private String incomeName;
	//收入项目类型
	private Integer incomeType;
	//项目年度净收入
	private String netIncome;
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

	public String getFarmerIdnum() {
		return farmerIdnum;
	}

	public void setFarmerIdnum(String farmerIdnum) {
		this.farmerIdnum = farmerIdnum;
	}

	public String getIncomeName() {
		return incomeName;
	}

	public void setIncomeName(String incomeName) {
		this.incomeName = incomeName;
	}

	public Integer getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(Integer incomeType) {
		this.incomeType = incomeType;
	}

	public String getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(String netIncome) {
		this.netIncome = netIncome;
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
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}

}
