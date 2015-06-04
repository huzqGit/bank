package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerCooperation extends BaseEntity<Long>{

	private static final long serialVersionUID = -4348831173556795845L;
	
	private String sortField;
	  
	private String sortOrder;
	
	private Long cooperationId;
	/**
	 * 农民专业经济合作组织名称
	 */
	private String cooperationName;
	private String orgaCode;
	private String taxCode;
	private String registerAddress;
	/**
	 * 通讯地址
	 */
	private String mailAddress;
	private Date registerDate;
	/**
	 * 注册资本
	 */
	private String registerCapital;
	private String realCapital;
	private String legalPerson;
	private String idNum;
	private String phone;
	private String members;
	/**
	 * 经营范围
	 */
	private String businesScope;
	private Integer businessArea;
	/**
	 * 带动农户(户)
	 */
	private Integer farmers;
	/**
	 * 连接基地
	 */
	private String connectionBase;
	private String recorder;
	private Date recordTime;
	
	
	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}

	public Long getCooperationId() {
		return cooperationId;
	}

	public void setCooperationId(Long cooperationId) {
		this.cooperationId = cooperationId;
	}

	public String getCooperationName() {
		return cooperationName;
	}

	public void setCooperationName(String cooperationName) {
		this.cooperationName = cooperationName;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getRegisterCapital() {
		return registerCapital;
	}

	public void setRegisterCapital(String registerCapital) {
		this.registerCapital = registerCapital;
	}

	public String getRealCapital() {
		return realCapital;
	}

	public void setRealCapital(String realCapital) {
		this.realCapital = realCapital;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getBusinesScope() {
		return businesScope;
	}

	public void setBusinesScope(String businesScope) {
		this.businesScope = businesScope;
	}

	public Integer getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(Integer businessArea) {
		this.businessArea = businessArea;
	}

	public Integer getFarmers() {
		return farmers;
	}

	public void setFarmers(Integer farmers) {
		this.farmers = farmers;
	}

	public String getConnectionBase() {
		return connectionBase;
	}

	public void setConnectionBase(String connectionBase) {
		this.connectionBase = connectionBase;
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

	public String getOrgaCode() {
		return orgaCode;
	}

	public void setOrgaCode(String orgaCode) {
		this.orgaCode = orgaCode;
	}
	
	public String getSortField() {
		return sortField;
	}
	
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	
	public String getSortOrder() {
		return sortOrder;
	}
	
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}