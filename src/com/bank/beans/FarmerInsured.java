package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerInsured extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4718082476820104198L;
	//户主身份证号
	private Long farmerId;
	//参保人姓名
	private String name;
	//被参加保险种类
	private String type;
	//参保金额
	private Double amount;
	//参保时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date insureTime;
	//参保到期日
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date limitTime;
	//记录人
	private String recorder;
	//记录时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date recordTime;
	

	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getInsureTime() {
		return insureTime;
	}

	public void setInsureTime(Date insureTime) {
		this.insureTime = insureTime;
	}

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
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
