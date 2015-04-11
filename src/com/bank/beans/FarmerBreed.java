package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerBreed extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2714377766892141459L;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdNum;
	//种养殖品种
	private String breedVariety;
	//年产量
	private String outputValue;
	//占地面积
	private String floorArea;
	//当前评估价格
	private String assessPrice;
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

	public String getBreedVariety() {
		return breedVariety;
	}

	public void setBreedVariety(String breedVariety) {
		this.breedVariety = breedVariety;
	}

	public String getOutputValue() {
		return outputValue;
	}

	public void setOutputValue(String outputValue) {
		this.outputValue = outputValue;
	}

	public String getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
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
