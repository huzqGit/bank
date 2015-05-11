package com.bank.beans;

import com.common.bean.BaseEntity;

public class FarmerEvaluate extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6808936993388416975L;
	//农户身份证号
	private Long farmerId;
	//人品综合评价
	private String personality;
	//家庭和睦情况
	private String harmonyStatus;
	//敬老爱幼幼情况
	private String respectStatus;
	//邻里团结情况
	private String neighborStatus;
	//是否遵纪守法
	private Integer legalStatus;
	//对公益事业关心程度
	private String welfareStatus;
	//是否诚实守信
	private Integer honestStatus;
	//其他
	private String otherStatus;
	
	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getHarmonyStatus() {
		return harmonyStatus;
	}

	public void setHarmonyStatus(String harmonyStatus) {
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

	public Integer getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(Integer legalStatus) {
		this.legalStatus = legalStatus;
	}

	public String getWelfareStatus() {
		return welfareStatus;
	}

	public void setWelfareStatus(String welfareStatus) {
		this.welfareStatus = welfareStatus;
	}

	public Integer getHonestStatus() {
		return honestStatus;
	}

	public void setHonestStatus(Integer honestStatus) {
		this.honestStatus = honestStatus;
	}

	public String getOtherStatus() {
		return otherStatus;
	}

	public void setOtherStatus(String otherStatus) {
		this.otherStatus = otherStatus;
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
