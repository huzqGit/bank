package com.bank.beans;

import java.util.Date;
import java.util.List;

import com.common.bean.BaseEntity;

public class FarmerHouse extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3527327656335653102L;
	//农户身份证号
	private Long farmerId;
	//房产性质
	private String houseProperty;
	//房屋类型
	private String houseType;
	//房屋地址
	private String houseAddress;
	//建筑面积
	private String buildArea;
	//构建年份
	private String buildDate;
	//构建价格
	private	String buildPrice;
	//占地面积
	private String floorArea;
	//当前评估价格
	private String assessPrice;
	
	

	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
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

	public String getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(String buildDate) {
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
	
	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}


}
