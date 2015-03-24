package com.bank.beans;

import com.common.bean.BaseEntity;

public class CompanyInvest extends BaseEntity<Long> {
	private Long investId;
	private String companyName;
	private String organCode;
	private String creditCode;
	private String investedcompanyName;
	private String investedoragnCode;
	private String investedloancardCode;
	private String investedregisterCode;
	private Integer investCurrency;
	private String investAmount;
	private Double equityShare;
	private String recorder;
	private String recordTime;
	
	public Long getInvestId() {
		return investId;
	}

	public void setInvestId(Long investId) {
		this.investId = investId;
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

	public String getInvestedcompanyName() {
		return investedcompanyName;
	}

	public void setInvestedcompanyName(String investedcompanyName) {
		this.investedcompanyName = investedcompanyName;
	}

	public String getInvestedoragnCode() {
		return investedoragnCode;
	}

	public void setInvestedoragnCode(String investedoragnCode) {
		this.investedoragnCode = investedoragnCode;
	}

	public String getInvestedloancardCode() {
		return investedloancardCode;
	}

	public void setInvestedloancardCode(String investedloancardCode) {
		this.investedloancardCode = investedloancardCode;
	}

	public String getInvestedregisterCode() {
		return investedregisterCode;
	}

	public void setInvestedregisterCode(String investedregisterCode) {
		this.investedregisterCode = investedregisterCode;
	}

	public Integer getInvestCurrency() {
		return investCurrency;
	}

	public void setInvestCurrency(Integer investCurrency) {
		this.investCurrency = investCurrency;
	}

	public String getInvestAmount() {
		return investAmount;
	}

	public void setInvestAmount(String investAmount) {
		this.investAmount = investAmount;
	}

	public Double getEquityShare() {
		return equityShare;
	}

	public void setEquityShare(Double equityShare) {
		this.equityShare = equityShare;
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
