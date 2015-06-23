package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerInsured extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4718082476820104198L;
	
	    private Long farmerid;

	    private String name;

	    private Integer type;

	    private Double amount;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date insuretime;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date limittime;

	    private String sourcecode;

	    private String sourcename;

	    private String runitid;

	    private String runitname;

	    private String recorder;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private Date recordtime;
	    
	    public Long getFarmerid() {
			return farmerid;
		}

		public void setFarmerid(Long farmerid) {
			this.farmerid = farmerid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public Date getInsuretime() {
			return insuretime;
		}

		public void setInsuretime(Date insuretime) {
			this.insuretime = insuretime;
		}

		public Date getLimittime() {
			return limittime;
		}

		public void setLimittime(Date limittime) {
			this.limittime = limittime;
		}

		public String getSourcecode() {
			return sourcecode;
		}

		public void setSourcecode(String sourcecode) {
			this.sourcecode = sourcecode;
		}

		public String getSourcename() {
			return sourcename;
		}

		public void setSourcename(String sourcename) {
			this.sourcename = sourcename;
		}

		public String getRunitid() {
			return runitid;
		}

		public void setRunitid(String runitid) {
			this.runitid = runitid;
		}

		public String getRunitname() {
			return runitname;
		}

		public void setRunitname(String runitname) {
			this.runitname = runitname;
		}

		public String getRecorder() {
			return recorder;
		}

		public void setRecorder(String recorder) {
			this.recorder = recorder;
		}

		public Date getRecordtime() {
			return recordtime;
		}

		public void setRecordtime(Date recordtime) {
			this.recordtime = recordtime;
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
