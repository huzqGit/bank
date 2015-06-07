package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class Cooperation extends BaseEntity<Long> {

	private static final long serialVersionUID = 6572454173068901580L;
	
	private String cooperationName;
	private String organCode;
	private String taxCode;
	private String registerAddress;
	private String mailAddress;
	private Date registerDate;
	private String registerCapital;
	private String realCapital;
	private String legalPerson;
	private String idNum;
	private String phone;
	private Integer members;
	private String bussinesScope;
	private Integer businessArea;
	private Integer farmers;
	private String connectionBase;
	private String recorder;
	private Date recordTime;
	
	
	public String getCooperationName() {
		return cooperationName;
	}

	public void setCooperationName(String cooperationName) {
		this.cooperationName = cooperationName;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
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

	public Integer getMembers() {
		return members;
	}

	public void setMembers(Integer members) {
		this.members = members;
	}

	public String getBussinesScope() {
		return bussinesScope;
	}

	public void setBussinesScope(String bussinesScope) {
		this.bussinesScope = bussinesScope;
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
