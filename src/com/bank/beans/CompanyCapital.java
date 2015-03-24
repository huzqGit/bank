package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class CompanyCapital extends BaseEntity<Long> {
	
	private Long capitalId;
	private String companyName;
	private String organCode;
	private String creditCode;
	private Integer registerCapital;
	private Integer currency;
	private Integer realCapital;
	private String capitalchkNum;
	private String investor;
	private String businessCode;
	private String idType;
	private String idNumber;
	private String investAmount;
	private String investStyle;
	private Date investDate;
	private String evaluateOrgan;
	private String recorder;
	private String recordTime;
	
	
	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}

	public Long getCapitalId() {
		return capitalId;
	}

	public void setCapitalId(Long capitalId) {
		this.capitalId = capitalId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}




	public Integer getRegisterCapital() {
		return registerCapital;
	}

	public void setRegisterCapital(Integer registerCapital) {
		this.registerCapital = registerCapital;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}



	public Integer getRealCapital() {
		return realCapital;
	}

	public void setRealCapital(Integer realCapital) {
		this.realCapital = realCapital;
	}

	public String getCapitalchkNum() {
		return capitalchkNum;
	}

	public void setCapitalchkNum(String capitalchkNum) {
		this.capitalchkNum = capitalchkNum;
	}

	public String getInvestor() {
		return investor;
	}

	public void setInvestor(String investor) {
		this.investor = investor;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getInvestAmount() {
		return investAmount;
	}

	public void setInvestAmount(String investAmount) {
		this.investAmount = investAmount;
	}

	public String getInvestStyle() {
		return investStyle;
	}

	public void setInvestStyle(String investStyle) {
		this.investStyle = investStyle;
	}

	public Date getInvestDate() {
		return investDate;
	}

	public void setInvestDate(Date investDate) {
		this.investDate = investDate;
	}



	public String getEvaluateOrgan() {
		return evaluateOrgan;
	}

	public void setEvaluateOrgan(String evaluateOrgan) {
		this.evaluateOrgan = evaluateOrgan;
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
	
}
