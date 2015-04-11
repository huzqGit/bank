package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerHouse extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3527327656335653102L;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdNum;
	//房产性质
	private String houseProperty;
	//房屋类型
	private String houseType;
	//房屋地址
	private String houseAddress;
	//建筑面积
	private String buildArea;
	//构建年份
	private Date buildDate;
	//构建价格
	private	String buildPrice;
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

	public String getHouseProperty() {
		return houseProperty;
	}

	public void setHouseProperty(String houseProperty) {
		this.houseProperty = houseProperty;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getBuildArea() {
		return buildArea;
	}

	public void setBuildArea(String buildArea) {
		this.buildArea = buildArea;
	}

	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public String getBuildPrice() {
		return buildPrice;
	}

	public void setBuildPrice(String buildPrice) {
		this.buildPrice = buildPrice;
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
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}

}
