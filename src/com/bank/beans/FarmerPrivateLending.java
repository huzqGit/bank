package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

@SuppressWarnings("serial")
public class FarmerPrivateLending extends BaseEntity<Long> {
	 	
		private Long farmerid;

	    private Double amount;

	    private Date lendingtime;

	    private Date limittime;

	    private Double rate;

	    private String sourcecode;

	    private String sourcename;

	    private String runitid;

	    private String runitname;

	    private String recorder;

	    private Date recordtime;

	    public Long getFarmerid() {
			return farmerid;
		}

		public void setFarmerid(Long farmerid) {
			this.farmerid = farmerid;
		}

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public Date getLendingtime() {
			return lendingtime;
		}

		public void setLendingtime(Date lendingtime) {
			this.lendingtime = lendingtime;
		}

		public Date getLimittime() {
			return limittime;
		}

		public void setLimittime(Date limittime) {
			this.limittime = limittime;
		}

		public Double getRate() {
			return rate;
		}

		public void setRate(Double rate) {
			this.rate = rate;
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
