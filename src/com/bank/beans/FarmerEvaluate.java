package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerEvaluate extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6808936993388416975L;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdNum;
	//人品综合评价
	private String personality;
	//家庭和睦情况
	private Integer harmonyStatus;
	//敬老爱幼幼情况
	private String respectStatus;
	//邻里团结情况
	private String neighborStatus;
	//是否遵纪守法
	private String legalStatus;
	//对公益事业关心程度
	private String welfareStatus;
	//是否诚实守信
	private String honestStatus;
	//其他
	private String otherStatus;
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

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public Integer getHarmonyStatus() {
		return harmonyStatus;
	}

	public void setHarmonyStatus(Integer harmonyStatus) {
		this.harmonyStatus = harmonyStatus;
	}

	public String getRespectStatus() {
		return respectStatus;
	}

	public void setRespectStatus(String respectStatus) {
		this.respectStatus = respectStatus;
	}

	public String getNeighborStatus() {
		return neighborStatus;
	}

	public void setNeighborStatus(String neighborStatus) {
		this.neighborStatus = neighborStatus;
	}

	public String getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

	public String getWelfareStatus() {
		return welfareStatus;
	}

	public void setWelfareStatus(String welfareStatus) {
		this.welfareStatus = welfareStatus;
	}

	public String getHonestStatus() {
		return honestStatus;
	}

	public void setHonestStatus(String honestStatus) {
		this.honestStatus = honestStatus;
	}

	public String getOtherStatus() {
		return otherStatus;
	}

	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
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
