package com.bank.beans;


import com.common.bean.BaseEntity;

public class FarmerIncome extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3001805087077814968L;
	private Long payId;
	//收入项目名称
	private String incomeName;
	//收入项目类型
	private Integer incomeType;
	//项目年度净收入
	private String netIncome;
	
	public Long getPayId() {
		return payId;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
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

	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}

}
